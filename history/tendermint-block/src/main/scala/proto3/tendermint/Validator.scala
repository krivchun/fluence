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

// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package proto3.tendermint

/** @param power
 *  PubKey pub_key = 2 // TODO: I wonder, why is it commented out?
 */
@SerialVersionUID(0L)
final case class Validator(
  address: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  power: _root_.scala.Long = 0L
) extends scalapb.GeneratedMessage with scalapb.Message[Validator] with scalapb.lenses.Updatable[Validator] {

  @transient
  private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
  private[this] def __computeSerializedValue(): _root_.scala.Int = {
    var __size = 0

    {
      val __value = address
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(1, __value)
      }
    };

    {
      val __value = power
      if (__value != 0L) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
      }
    };
    __size
  }
  final override def serializedSize: _root_.scala.Int = {
    var read = __serializedSizeCachedValue
    if (read == 0) {
      read = __computeSerializedValue()
      __serializedSizeCachedValue = read
    }
    read
  }

  def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
    {
      val __v = address
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(1, __v)
      }
    };
    {
      val __v = power
      if (__v != 0L) {
        _output__.writeInt64(3, __v)
      }
    };
  }

  def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): proto3.tendermint.Validator = {
    var __address = this.address
    var __power = this.power
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __address = _input__.readBytes()
        case 24 =>
          __power = _input__.readInt64()
        case tag => _input__.skipField(tag)
      }
    }
    proto3.tendermint.Validator(
      address = __address,
      power = __power
    )
  }
  def withAddress(__v: _root_.com.google.protobuf.ByteString): Validator = copy(address = __v)
  def withPower(__v: _root_.scala.Long): Validator = copy(power = __v)

  def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
    (__fieldNumber: @ _root_.scala.unchecked) match {
      case 1 => {
        val __t = address
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 3 => {
        val __t = power
        if (__t != 0L) __t else null
      }
    }
  }

  def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
    _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
    (__field.number: @ _root_.scala.unchecked) match {
      case 1 => _root_.scalapb.descriptors.PByteString(address)
      case 3 => _root_.scalapb.descriptors.PLong(power)
    }
  }
  def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
  def companion = proto3.tendermint.Validator
}

object Validator extends scalapb.GeneratedMessageCompanion[proto3.tendermint.Validator] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[proto3.tendermint.Validator] = this

  def fromFieldsMap(
    __fieldsMap: scala.collection.immutable.Map[
      _root_.com.google.protobuf.Descriptors.FieldDescriptor,
      _root_.scala.Any
    ]
  ): proto3.tendermint.Validator = {
    _root_.scala.Predef.require(
      __fieldsMap.keys.forall(_.getContainingType() == javaDescriptor),
      "FieldDescriptor does not match message type."
    )
    val __fields = javaDescriptor.getFields
    proto3.tendermint.Validator(
      __fieldsMap
        .getOrElse(__fields.get(0), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap.getOrElse(__fields.get(1), 0L).asInstanceOf[_root_.scala.Long]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[proto3.tendermint.Validator] =
    _root_.scalapb.descriptors.Reads {
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(
          __fieldsMap.keys.forall(_.containingMessage == scalaDescriptor),
          "FieldDescriptor does not match message type."
        )
        proto3.tendermint.Validator(
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(1).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }

  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor =
    TendermintProto.javaDescriptor.getMessageTypes.get(10)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TendermintProto.scalaDescriptor.messages(10)

  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] =
    throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_]] = Seq.empty

  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] =
    throw new MatchError(__fieldNumber)
  lazy val defaultInstance = proto3.tendermint.Validator(
    )
  implicit class ValidatorLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, proto3.tendermint.Validator])
      extends _root_.scalapb.lenses.ObjectLens[UpperPB, proto3.tendermint.Validator](_l) {

    def address: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.address)((c_, f_) => c_.copy(address = f_))
    def power: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.power)((c_, f_) => c_.copy(power = f_))
  }
  final val ADDRESS_FIELD_NUMBER = 1
  final val POWER_FIELD_NUMBER = 3
}
