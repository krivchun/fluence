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

@SerialVersionUID(0L)
final case class Timestamp(
  seconds: _root_.scala.Long = 0L,
  nanos: _root_.scala.Int = 0
) extends scalapb.GeneratedMessage with scalapb.Message[Timestamp] with scalapb.lenses.Updatable[Timestamp] {

  @transient
  private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
  private[this] def __computeSerializedValue(): _root_.scala.Int = {
    var __size = 0

    {
      val __value = seconds
      if (__value != 0L) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
      }
    };

    {
      val __value = nanos
      if (__value != 0) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
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
      val __v = seconds
      if (__v != 0L) {
        _output__.writeInt64(1, __v)
      }
    };
    {
      val __v = nanos
      if (__v != 0) {
        _output__.writeInt32(2, __v)
      }
    };
  }

  def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): proto3.tendermint.Timestamp = {
    var __seconds = this.seconds
    var __nanos = this.nanos
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __seconds = _input__.readInt64()
        case 16 =>
          __nanos = _input__.readInt32()
        case tag => _input__.skipField(tag)
      }
    }
    proto3.tendermint.Timestamp(
      seconds = __seconds,
      nanos = __nanos
    )
  }
  def withSeconds(__v: _root_.scala.Long): Timestamp = copy(seconds = __v)
  def withNanos(__v: _root_.scala.Int): Timestamp = copy(nanos = __v)

  def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
    (__fieldNumber: @ _root_.scala.unchecked) match {
      case 1 => {
        val __t = seconds
        if (__t != 0L) __t else null
      }
      case 2 => {
        val __t = nanos
        if (__t != 0) __t else null
      }
    }
  }

  def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
    _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
    (__field.number: @ _root_.scala.unchecked) match {
      case 1 => _root_.scalapb.descriptors.PLong(seconds)
      case 2 => _root_.scalapb.descriptors.PInt(nanos)
    }
  }
  def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
  def companion = proto3.tendermint.Timestamp
}

object Timestamp extends scalapb.GeneratedMessageCompanion[proto3.tendermint.Timestamp] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[proto3.tendermint.Timestamp] = this

  def fromFieldsMap(
    __fieldsMap: scala.collection.immutable.Map[
      _root_.com.google.protobuf.Descriptors.FieldDescriptor,
      _root_.scala.Any
    ]
  ): proto3.tendermint.Timestamp = {
    _root_.scala.Predef.require(
      __fieldsMap.keys.forall(_.getContainingType() == javaDescriptor),
      "FieldDescriptor does not match message type."
    )
    val __fields = javaDescriptor.getFields
    proto3.tendermint.Timestamp(
      __fieldsMap.getOrElse(__fields.get(0), 0L).asInstanceOf[_root_.scala.Long],
      __fieldsMap.getOrElse(__fields.get(1), 0).asInstanceOf[_root_.scala.Int]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[proto3.tendermint.Timestamp] =
    _root_.scalapb.descriptors.Reads {
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(
          __fieldsMap.keys.forall(_.containingMessage == scalaDescriptor),
          "FieldDescriptor does not match message type."
        )
        proto3.tendermint.Timestamp(
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0)
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }

  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor =
    TendermintProto.javaDescriptor.getMessageTypes.get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TendermintProto.scalaDescriptor.messages(2)

  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] =
    throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_]] = Seq.empty

  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] =
    throw new MatchError(__fieldNumber)
  lazy val defaultInstance = proto3.tendermint.Timestamp(
    )
  implicit class TimestampLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, proto3.tendermint.Timestamp])
      extends _root_.scalapb.lenses.ObjectLens[UpperPB, proto3.tendermint.Timestamp](_l) {

    def seconds: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] =
      field(_.seconds)((c_, f_) => c_.copy(seconds = f_))
    def nanos: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.nanos)((c_, f_) => c_.copy(nanos = f_))
  }
  final val SECONDS_FIELD_NUMBER = 1
  final val NANOS_FIELD_NUMBER = 2
}