/*
 * Copyright 2018 Fluence Labs Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fluence.vm

import cats.Monad
import cats.data.EitherT
import cats.effect.IO
import fluence.crypto.{Crypto, CryptoError, DumbCrypto}
import fluence.vm.TestUtils._
import fluence.vm.VmError._
import org.scalatest.{Matchers, WordSpec}

import scala.language.{higherKinds, implicitConversions}

class WasmVmImplSpec extends WordSpec with Matchers {

  "invoke" should {
    "raise error" when {

      "unable to find a function" in {
        val sumFile = getClass.getResource("/wast/sum.wast").getPath

        val res = for {
          vm <- WasmVm[IO](Seq(sumFile))
          result ← vm.invoke[IO](None, "wrongFnName", Seq("100", "13", "extraArg")).toVmError
        } yield result
        val error = res.failed()
        error shouldBe a[NoSuchFnError]
        error.getMessage should startWith("Unable to find a function with the name='<no-name>.wrongFnName'")
      }

      "invalid number of arguments" in {
        val sumFile = getClass.getResource("/wast/sum.wast").getPath
        val res = for {
          vm <- WasmVm[IO](Seq(sumFile))
          result ← vm.invoke[IO](None, "sum", Seq("100", "13", "extraArg")).toVmError
        } yield result
        val error = res.failed()
        error shouldBe a[InvalidArgError]
        error.getMessage should startWith(
          "Invalid number of arguments, expected=2, actually=3 for fn='<no-name>.sum'"
        )
      }

      "invalid type for arguments" in {
        val sumFile = getClass.getResource("/wast/sum.wast").getPath
        val res = for {
          vm <- WasmVm[IO](Seq(sumFile))
          result ← vm.invoke[IO](None, "sum", Seq("stringParam", "[1, 2, 3]")).toVmError
        } yield result
        val error = res.failed()
        error shouldBe a[InvalidArgError]
        error.getMessage should startWith("Arg 0 of 'stringParam' not an int")
      }

      "wasm code fell into the trap" in {
        val sumFile = getClass.getResource("/wast/sum-with-trap.wast").getPath
        val res = for {
          vm <- WasmVm[IO](Seq(sumFile))
          result ← vm.invoke[IO](None, "sum", Seq("100", "13")).toVmError // Integer overflow
        } yield result
        val error = res.failed()
        error shouldBe a[TrapError]
        error.getMessage should startWith("Function '<no-name>.sum' with args: List(100, 13) was failed")
      }

    }
  }

  "invokes function success" when {
    "run sum.wast" in {
      val sumFile = getClass.getResource("/wast/sum.wast").getPath

      val res = for {
        vm <- WasmVm[IO](Seq(sumFile))
        result ← vm.invoke[IO](None, "sum", Seq("100", "13")).toVmError
      } yield result shouldBe Some(113)

      res.success()
    }

    "run sum.wast and after that mul.wast" in {
      val sumFile = getClass.getResource("/wast/sum.wast").getPath
      val mulFile = getClass.getResource("/wast/mul.wast").getPath

      val res = for {
        vm <- WasmVm[IO](Seq(mulFile, sumFile))
        mulResult ← vm.invoke[IO](Some("multiplier"), "mul", Seq("100", "13"))
        sumResult ← vm.invoke[IO](None, "sum", Seq("100", "13")).toVmError
      } yield {
        mulResult shouldBe Some(1300)
        sumResult shouldBe Some(113)
      }

      res.success()
    }

    "run counter.wast" in {
      val file = getClass.getResource("/wast/counter.wast").getPath

      val res = for {
        vm <- WasmVm[IO](Seq(file))
        get0 ← vm.invoke[IO](None, "get", Nil) // read 0
        _ ← vm.invoke[IO](None, "inc", Nil) // 0 -> 1
        get1 ← vm.invoke[IO](None, "get", Nil) // read 1
        _ ← vm.invoke[IO](None, "inc", Nil) // 1 -> 2
        _ ← vm.invoke[IO](None, "inc", Nil) // 2 -> 3
        get3 ← vm.invoke[IO](None, "get", Nil).toVmError //read 3
      } yield {
        get0 shouldBe Some(0)
        get1 shouldBe Some(1)
        get3 shouldBe Some(3)
      }

      res.success()
    }

  }

  "getVmState" should {
    "raise an error" when {
      "getting inner state for module failed" in {
        val counterFile = getClass.getResource("/wast/counter.wast").getPath
        val badHasher = new Crypto.Hasher[Array[Byte], Array[Byte]] {
          override def apply[F[_]: Monad](input: Array[Byte]): EitherT[F, CryptoError, Array[Byte]] =
            EitherT.leftT(CryptoError("error!"))
        }
        val res = for {
          vm <- WasmVm[IO](Seq(counterFile), cryptoHasher = badHasher)
          state ← vm.getVmState[IO].toVmError
        } yield state

        val error = res.failed()
        error.getMessage shouldBe "Getting internal state for module=<no-name> failed"
        error.getCause shouldBe a[CryptoError]
        error shouldBe a[InternalVmError]
      }

    }

    "returns state" when {
      "there is one module without memory present" in {
        val testHasher = DumbCrypto.testHasher
        // the code in 'sum.wast' don't use 'memory', instance for this module created without 'memory' field
        val sumFile = getClass.getResource("/wast/sum.wast").getPath

        val res = for {
          vm <- WasmVm[IO](Seq(sumFile), cryptoHasher = testHasher)
          result ← vm.invoke[IO](None, "sum", Seq("100", "13"))
          state ← vm.getVmState[IO].toVmError
        } yield {
          result shouldBe Some(113)
          state.toArray shouldBe testHasher.unsafe(Array.emptyByteArray)
        }

        res.success()
      }

      "there is one module with memory present" in {
        // the code in 'counter.wast' uses 'memory', instance for this module created with 'memory' field
        val counterFile = getClass.getResource("/wast/counter.wast").getPath

        val res = for {
          vm <- WasmVm[IO](Seq(counterFile))
          _ ← vm.invoke[IO](None, "inc", Nil) // 0 -> 1
          get1 ← vm.invoke[IO](None, "get", Nil) // read 1
          state1 ← vm.getVmState[IO]
          get1AfterGettingState ← vm.invoke[IO](None, "get", Nil) // read 1

          _ ← vm.invoke[IO](None, "inc", Nil) // 1 -> 2
          state2 ← vm.getVmState[IO]
          get2AfterGettingState ← vm.invoke[IO](None, "get", Nil).toVmError // read 2
        } yield {
          get1 shouldBe Some(1)
          get1AfterGettingState shouldBe Some(1)
          get2AfterGettingState shouldBe Some(2)
          state1.size shouldBe 32
          state2.size shouldBe 32
          state1 should not be state2
        }

        res.success()
      }

      "there are several modules present" in {
        val counterFile = getClass.getResource("/wast/counter.wast").getPath
        val counterCopyFile = getClass.getResource("/wast/counter-copy.wast").getPath
        val mulFile = getClass.getResource("/wast/mul.wast").getPath

        val res = for {
          vm <- WasmVm[IO](Seq(counterCopyFile, mulFile, counterFile))

          _ ← vm.invoke[IO](None, "inc", Nil) // 0 -> 1
          get1 ← vm.invoke[IO](None, "get", Nil) // read 1
          _ ← vm.invoke[IO](Some("counter-copy"), "inc", Nil) // 0 -> 1
          getFromCopy1 ← vm.invoke[IO](Some("counter-copy"), "get", Nil) // read 1
          sum1 ← vm.invoke[IO](Some("multiplier"), "mul", Seq("100", "13")) // read 1

          state1 ← vm.getVmState[IO]

          _ ← vm.invoke[IO](None, "inc", Nil) // 1 -> 2
          _ ← vm.invoke[IO](Some("counter-copy"), "inc", Nil) // 1 -> 2

          state2 ← vm.getVmState[IO].toVmError

        } yield {
          get1 shouldBe Some(1)
          getFromCopy1 shouldBe Some(1)
          state1.size shouldBe 32
          state2.size shouldBe 32
          state1 should not be state2
        }

        res.success()
      }

    }
  }

}