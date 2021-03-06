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

package fluence.node.workers.tendermint

import fluence.effects.ethclient.helpers.Web3jConverters.base64ToBytes32
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import org.web3j.abi.datatypes.generated.Bytes32
import scodec.bits.ByteVector

/**
 * Validator's public key in Tendermint-compatible format.
 *
 * @param `type` key type
 * @param value 32-byte public key in base64 representation
 */
case class ValidatorPublicKey(`type`: String, value: String) {

  /**
   * Returns node's public key in format ready to pass to the contract.
   */
  lazy val toBytes32: Bytes32 = base64ToBytes32(value)

  lazy val toByteVector: ByteVector = ByteVector(toBytes32.getValue)
}

object ValidatorPublicKey {
  implicit val validatorKeyDecoder: Decoder[ValidatorPublicKey] = deriveDecoder[ValidatorPublicKey]

  implicit val validatorKeyEncoder: Encoder[ValidatorPublicKey] = deriveEncoder[ValidatorPublicKey]
}
