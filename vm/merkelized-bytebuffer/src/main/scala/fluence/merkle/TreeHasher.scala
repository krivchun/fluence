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

package fluence.merkle

import java.nio.ByteBuffer
import java.security.MessageDigest

/**
 * Represents hash calculation for BinayMerkleTree.
 */
trait TreeHasher {
  def digest(arr: Array[Byte]): Array[Byte]
  def digest(bb: ByteBuffer): Array[Byte]
}

object TreeHasher {
  def apply(digester: MessageDigest): TreeHasher = new DigesterTreeHasher(digester)
}

/**
 * Hasher that does nothing and returns input. For test purpose only.
 */
private[this] class PlainTreeHasher extends TreeHasher {
  override def digest(arr: Array[Byte]): Array[Byte] = arr

  override def digest(bb: ByteBuffer): Array[Byte] = {
    val remaining = bb.remaining()
    val arr = new Array[Byte](remaining)
    bb.get(arr)
    arr
  }
}

/**
 * Uses standard JVM digester.
 *
 * @param digester provides applications the functionality of a message digest algorithm
 *
 */
class DigesterTreeHasher(digester: MessageDigest) extends TreeHasher {
  override def digest(arr: Array[Byte]): Array[Byte] = digester.digest(arr)

  override def digest(bb: ByteBuffer): Array[Byte] = {
    digester.update(bb)
    digester.digest()
  }
}
