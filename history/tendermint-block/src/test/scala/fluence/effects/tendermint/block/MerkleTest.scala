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

package fluence.effects.tendermint.block

import fluence.effects.tendermint.block.data.Block
import fluence.effects.tendermint.block.signature.Merkle
import org.scalatest.{FunSpec, Matchers, OptionValues}
import scodec.bits.ByteVector

class MerkleTest extends FunSpec with Matchers with OptionValues {
  val block = Block(TestData.blockResponse).right.get
  def toHex(ba: Array[Byte]) = ByteVector(ba).toHex
  def checkHex(scalaHex: String, goHex: String) = scalaHex.toLowerCase shouldBe goHex.toLowerCase

  describe("usual block") {
    it("merkle hash, size = 32") {
      val data = (1 to 32).map(i => Array.fill[Byte](4)(i.toByte)).toList
      val goHash = "62BDC2B8D88E187E4CEEBDDD72F3C8CB8DC98F64D620CAD92AF553B70D567816"
      val scalaHash = Merkle.simpleHash(data)
      val scalaHex = ByteVector(scalaHash).toHex

      goHash.toLowerCase shouldBe scalaHex.toLowerCase
    }

    it("merkle hash, size = 92") {
      val data = (1 to 92).map(i => Array.fill[Byte](4)(i.toByte)).toList
      val goHash = "672B5E8C92A04FABF1EDB44EF70F50749B850EDCC767E565728BC3A1DF0F49CF"
      val scalaHash = Merkle.simpleHash(data)
      val scalaHex = ByteVector(scalaHash).toHex

      goHash.toLowerCase shouldBe scalaHex.toLowerCase
    }

    it("block merkle hash") {
      val scalaHex = toHex(block.headerHash())
      val goHex = "C921CCB37C268965A56FC546713419AEF683201D5151613E07CBD9293308027F"

      checkHex(scalaHex, goHex)
    }

    it("block parts merkle hash") {
      val scalaHex = toHex(block.partsHash().hash)
      val goHex = "046C3623869234B711759E66664CC5728B16F577C8D3FFE436278C4D8075E635"

      checkHex(scalaHex, goHex)
    }
  }

  describe("block with data = null") {
    val blockEmpty = Block(TestData.blockNullTxsResponse).right.get

    it("block parts merkle hash") {
      val scalaHex = toHex(blockEmpty.partsHash().hash)
      val goHex = "A5C8730981D8723EAA64087926F81C49D0DA5A082D0237EAC833E2B3E294E777"

      checkHex(scalaHex, goHex)
    }
  }
}
