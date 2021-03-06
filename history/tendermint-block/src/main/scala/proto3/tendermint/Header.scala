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

/** @param version
 *   basic block info
 * @param lastBlockId
 *   prev block info
 * @param lastCommitHash
 *   hashes of block data
 *   commit from validators from the last block
 * @param dataHash
 *   transactions
 * @param validatorsHash
 *   hashes from the app output from the prev block
 *   validators for the current block
 * @param nextValidatorsHash
 *   validators for the next block
 * @param consensusHash
 *   consensus params for current block
 * @param appHash
 *   state after txs from the previous block
 * @param lastResultsHash
 *   root hash of all results from the txs from the previous block
 * @param evidenceHash
 *   consensus info
 *   evidence included in the block
 * @param proposerAddress
 *   original proposer of the block
 */
@SerialVersionUID(0L)
final case class Header(
  version: _root_.scala.Option[proto3.tendermint.Version] = None,
  chainId: _root_.scala.Predef.String = "",
  height: _root_.scala.Long = 0L,
  time: _root_.scala.Option[com.google.protobuf.timestamp.Timestamp] = None,
  numTxs: _root_.scala.Long = 0L,
  totalTxs: _root_.scala.Long = 0L,
  lastBlockId: _root_.scala.Option[proto3.tendermint.BlockID] = None,
  lastCommitHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  dataHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  validatorsHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  nextValidatorsHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  consensusHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  appHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  lastResultsHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  evidenceHash: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY,
  proposerAddress: _root_.com.google.protobuf.ByteString = _root_.com.google.protobuf.ByteString.EMPTY
) extends scalapb.GeneratedMessage with scalapb.Message[Header] with scalapb.lenses.Updatable[Header] {

  @transient
  private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
  private[this] def __computeSerializedValue(): _root_.scala.Int = {
    var __size = 0
    if (version.isDefined) {
      val __value = version.get
      __size += 1 + _root_.com.google.protobuf.CodedOutputStream
        .computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
    };

    {
      val __value = chainId
      if (__value != "") {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
      }
    };

    {
      val __value = height
      if (__value != 0L) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
      }
    };
    if (time.isDefined) {
      val __value = time.get
      __size += 1 + _root_.com.google.protobuf.CodedOutputStream
        .computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
    };

    {
      val __value = numTxs
      if (__value != 0L) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(5, __value)
      }
    };

    {
      val __value = totalTxs
      if (__value != 0L) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(6, __value)
      }
    };
    if (lastBlockId.isDefined) {
      val __value = lastBlockId.get
      __size += 1 + _root_.com.google.protobuf.CodedOutputStream
        .computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
    };

    {
      val __value = lastCommitHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(8, __value)
      }
    };

    {
      val __value = dataHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(9, __value)
      }
    };

    {
      val __value = validatorsHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(10, __value)
      }
    };

    {
      val __value = nextValidatorsHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(11, __value)
      }
    };

    {
      val __value = consensusHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(12, __value)
      }
    };

    {
      val __value = appHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(13, __value)
      }
    };

    {
      val __value = lastResultsHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(14, __value)
      }
    };

    {
      val __value = evidenceHash
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(15, __value)
      }
    };

    {
      val __value = proposerAddress
      if (__value != _root_.com.google.protobuf.ByteString.EMPTY) {
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBytesSize(16, __value)
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
    version.foreach { __v =>
      val __m = __v
      _output__.writeTag(1, 2)
      _output__.writeUInt32NoTag(__m.serializedSize)
      __m.writeTo(_output__)
    };
    {
      val __v = chainId
      if (__v != "") {
        _output__.writeString(2, __v)
      }
    };
    {
      val __v = height
      if (__v != 0L) {
        _output__.writeInt64(3, __v)
      }
    };
    time.foreach { __v =>
      val __m = __v
      _output__.writeTag(4, 2)
      _output__.writeUInt32NoTag(__m.serializedSize)
      __m.writeTo(_output__)
    };
    {
      val __v = numTxs
      if (__v != 0L) {
        _output__.writeInt64(5, __v)
      }
    };
    {
      val __v = totalTxs
      if (__v != 0L) {
        _output__.writeInt64(6, __v)
      }
    };
    lastBlockId.foreach { __v =>
      val __m = __v
      _output__.writeTag(7, 2)
      _output__.writeUInt32NoTag(__m.serializedSize)
      __m.writeTo(_output__)
    };
    {
      val __v = lastCommitHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(8, __v)
      }
    };
    {
      val __v = dataHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(9, __v)
      }
    };
    {
      val __v = validatorsHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(10, __v)
      }
    };
    {
      val __v = nextValidatorsHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(11, __v)
      }
    };
    {
      val __v = consensusHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(12, __v)
      }
    };
    {
      val __v = appHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(13, __v)
      }
    };
    {
      val __v = lastResultsHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(14, __v)
      }
    };
    {
      val __v = evidenceHash
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(15, __v)
      }
    };
    {
      val __v = proposerAddress
      if (__v != _root_.com.google.protobuf.ByteString.EMPTY) {
        _output__.writeBytes(16, __v)
      }
    };
  }

  def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): proto3.tendermint.Header = {
    var __version = this.version
    var __chainId = this.chainId
    var __height = this.height
    var __time = this.time
    var __numTxs = this.numTxs
    var __totalTxs = this.totalTxs
    var __lastBlockId = this.lastBlockId
    var __lastCommitHash = this.lastCommitHash
    var __dataHash = this.dataHash
    var __validatorsHash = this.validatorsHash
    var __nextValidatorsHash = this.nextValidatorsHash
    var __consensusHash = this.consensusHash
    var __appHash = this.appHash
    var __lastResultsHash = this.lastResultsHash
    var __evidenceHash = this.evidenceHash
    var __proposerAddress = this.proposerAddress
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __version = Option(
            _root_.scalapb.LiteParser
              .readMessage(_input__, __version.getOrElse(proto3.tendermint.Version.defaultInstance))
          )
        case 18 =>
          __chainId = _input__.readString()
        case 24 =>
          __height = _input__.readInt64()
        case 34 =>
          __time = Option(
            _root_.scalapb.LiteParser
              .readMessage(_input__, __time.getOrElse(com.google.protobuf.timestamp.Timestamp.defaultInstance))
          )
        case 40 =>
          __numTxs = _input__.readInt64()
        case 48 =>
          __totalTxs = _input__.readInt64()
        case 58 =>
          __lastBlockId = Option(
            _root_.scalapb.LiteParser
              .readMessage(_input__, __lastBlockId.getOrElse(proto3.tendermint.BlockID.defaultInstance))
          )
        case 66 =>
          __lastCommitHash = _input__.readBytes()
        case 74 =>
          __dataHash = _input__.readBytes()
        case 82 =>
          __validatorsHash = _input__.readBytes()
        case 90 =>
          __nextValidatorsHash = _input__.readBytes()
        case 98 =>
          __consensusHash = _input__.readBytes()
        case 106 =>
          __appHash = _input__.readBytes()
        case 114 =>
          __lastResultsHash = _input__.readBytes()
        case 122 =>
          __evidenceHash = _input__.readBytes()
        case 130 =>
          __proposerAddress = _input__.readBytes()
        case tag => _input__.skipField(tag)
      }
    }
    proto3.tendermint.Header(
      version = __version,
      chainId = __chainId,
      height = __height,
      time = __time,
      numTxs = __numTxs,
      totalTxs = __totalTxs,
      lastBlockId = __lastBlockId,
      lastCommitHash = __lastCommitHash,
      dataHash = __dataHash,
      validatorsHash = __validatorsHash,
      nextValidatorsHash = __nextValidatorsHash,
      consensusHash = __consensusHash,
      appHash = __appHash,
      lastResultsHash = __lastResultsHash,
      evidenceHash = __evidenceHash,
      proposerAddress = __proposerAddress
    )
  }
  def getVersion: proto3.tendermint.Version = version.getOrElse(proto3.tendermint.Version.defaultInstance)
  def clearVersion: Header = copy(version = None)
  def withVersion(__v: proto3.tendermint.Version): Header = copy(version = Option(__v))
  def withChainId(__v: _root_.scala.Predef.String): Header = copy(chainId = __v)
  def withHeight(__v: _root_.scala.Long): Header = copy(height = __v)

  def getTime: com.google.protobuf.timestamp.Timestamp =
    time.getOrElse(com.google.protobuf.timestamp.Timestamp.defaultInstance)
  def clearTime: Header = copy(time = None)
  def withTime(__v: com.google.protobuf.timestamp.Timestamp): Header = copy(time = Option(__v))
  def withNumTxs(__v: _root_.scala.Long): Header = copy(numTxs = __v)
  def withTotalTxs(__v: _root_.scala.Long): Header = copy(totalTxs = __v)
  def getLastBlockId: proto3.tendermint.BlockID = lastBlockId.getOrElse(proto3.tendermint.BlockID.defaultInstance)
  def clearLastBlockId: Header = copy(lastBlockId = None)
  def withLastBlockId(__v: proto3.tendermint.BlockID): Header = copy(lastBlockId = Option(__v))
  def withLastCommitHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(lastCommitHash = __v)
  def withDataHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(dataHash = __v)
  def withValidatorsHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(validatorsHash = __v)
  def withNextValidatorsHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(nextValidatorsHash = __v)
  def withConsensusHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(consensusHash = __v)
  def withAppHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(appHash = __v)
  def withLastResultsHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(lastResultsHash = __v)
  def withEvidenceHash(__v: _root_.com.google.protobuf.ByteString): Header = copy(evidenceHash = __v)
  def withProposerAddress(__v: _root_.com.google.protobuf.ByteString): Header = copy(proposerAddress = __v)

  def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
    (__fieldNumber: @ _root_.scala.unchecked) match {
      case 1 => version.orNull
      case 2 => {
        val __t = chainId
        if (__t != "") __t else null
      }
      case 3 => {
        val __t = height
        if (__t != 0L) __t else null
      }
      case 4 => time.orNull
      case 5 => {
        val __t = numTxs
        if (__t != 0L) __t else null
      }
      case 6 => {
        val __t = totalTxs
        if (__t != 0L) __t else null
      }
      case 7 => lastBlockId.orNull
      case 8 => {
        val __t = lastCommitHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 9 => {
        val __t = dataHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 10 => {
        val __t = validatorsHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 11 => {
        val __t = nextValidatorsHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 12 => {
        val __t = consensusHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 13 => {
        val __t = appHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 14 => {
        val __t = lastResultsHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 15 => {
        val __t = evidenceHash
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
      case 16 => {
        val __t = proposerAddress
        if (__t != _root_.com.google.protobuf.ByteString.EMPTY) __t else null
      }
    }
  }

  def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
    _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
    (__field.number: @ _root_.scala.unchecked) match {
      case 1  => version.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      case 2  => _root_.scalapb.descriptors.PString(chainId)
      case 3  => _root_.scalapb.descriptors.PLong(height)
      case 4  => time.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      case 5  => _root_.scalapb.descriptors.PLong(numTxs)
      case 6  => _root_.scalapb.descriptors.PLong(totalTxs)
      case 7  => lastBlockId.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      case 8  => _root_.scalapb.descriptors.PByteString(lastCommitHash)
      case 9  => _root_.scalapb.descriptors.PByteString(dataHash)
      case 10 => _root_.scalapb.descriptors.PByteString(validatorsHash)
      case 11 => _root_.scalapb.descriptors.PByteString(nextValidatorsHash)
      case 12 => _root_.scalapb.descriptors.PByteString(consensusHash)
      case 13 => _root_.scalapb.descriptors.PByteString(appHash)
      case 14 => _root_.scalapb.descriptors.PByteString(lastResultsHash)
      case 15 => _root_.scalapb.descriptors.PByteString(evidenceHash)
      case 16 => _root_.scalapb.descriptors.PByteString(proposerAddress)
    }
  }
  def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
  def companion = proto3.tendermint.Header
}

object Header extends scalapb.GeneratedMessageCompanion[proto3.tendermint.Header] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[proto3.tendermint.Header] = this

  def fromFieldsMap(
    __fieldsMap: scala.collection.immutable.Map[
      _root_.com.google.protobuf.Descriptors.FieldDescriptor,
      _root_.scala.Any
    ]
  ): proto3.tendermint.Header = {
    _root_.scala.Predef.require(
      __fieldsMap.keys.forall(_.getContainingType() == javaDescriptor),
      "FieldDescriptor does not match message type."
    )
    val __fields = javaDescriptor.getFields
    proto3.tendermint.Header(
      __fieldsMap.get(__fields.get(0)).asInstanceOf[_root_.scala.Option[proto3.tendermint.Version]],
      __fieldsMap.getOrElse(__fields.get(1), "").asInstanceOf[_root_.scala.Predef.String],
      __fieldsMap.getOrElse(__fields.get(2), 0L).asInstanceOf[_root_.scala.Long],
      __fieldsMap.get(__fields.get(3)).asInstanceOf[_root_.scala.Option[com.google.protobuf.timestamp.Timestamp]],
      __fieldsMap.getOrElse(__fields.get(4), 0L).asInstanceOf[_root_.scala.Long],
      __fieldsMap.getOrElse(__fields.get(5), 0L).asInstanceOf[_root_.scala.Long],
      __fieldsMap.get(__fields.get(6)).asInstanceOf[_root_.scala.Option[proto3.tendermint.BlockID]],
      __fieldsMap
        .getOrElse(__fields.get(7), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(8), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(9), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(10), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(11), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(12), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(13), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(14), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString],
      __fieldsMap
        .getOrElse(__fields.get(15), _root_.com.google.protobuf.ByteString.EMPTY)
        .asInstanceOf[_root_.com.google.protobuf.ByteString]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[proto3.tendermint.Header] =
    _root_.scalapb.descriptors.Reads {
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(
          __fieldsMap.keys.forall(_.containingMessage == scalaDescriptor),
          "FieldDescriptor does not match message type."
        )
        proto3.tendermint.Header(
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(1).get)
            .flatMap(_.as[_root_.scala.Option[proto3.tendermint.Version]]),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(4).get)
            .flatMap(_.as[_root_.scala.Option[com.google.protobuf.timestamp.Timestamp]]),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(7).get)
            .flatMap(_.as[_root_.scala.Option[proto3.tendermint.BlockID]]),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(8).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(9).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(10).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(11).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(12).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(13).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(14).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(15).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY),
          __fieldsMap
            .get(scalaDescriptor.findFieldByNumber(16).get)
            .map(_.as[_root_.com.google.protobuf.ByteString])
            .getOrElse(_root_.com.google.protobuf.ByteString.EMPTY)
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }

  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor =
    TendermintProto.javaDescriptor.getMessageTypes.get(4)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TendermintProto.scalaDescriptor.messages(4)

  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @ _root_.scala.unchecked) match {
      case 1 => __out = proto3.tendermint.Version
      case 4 => __out = com.google.protobuf.timestamp.Timestamp
      case 7 => __out = proto3.tendermint.BlockID
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_]] = Seq.empty

  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] =
    throw new MatchError(__fieldNumber)
  lazy val defaultInstance = proto3.tendermint.Header(
    )
  implicit class HeaderLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, proto3.tendermint.Header])
      extends _root_.scalapb.lenses.ObjectLens[UpperPB, proto3.tendermint.Header](_l) {

    def version: _root_.scalapb.lenses.Lens[UpperPB, proto3.tendermint.Version] =
      field(_.getVersion)((c_, f_) => c_.copy(version = Option(f_)))

    def optionalVersion: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[proto3.tendermint.Version]] =
      field(_.version)((c_, f_) => c_.copy(version = f_))

    def chainId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] =
      field(_.chainId)((c_, f_) => c_.copy(chainId = f_))

    def height: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] =
      field(_.height)((c_, f_) => c_.copy(height = f_))

    def time: _root_.scalapb.lenses.Lens[UpperPB, com.google.protobuf.timestamp.Timestamp] =
      field(_.getTime)((c_, f_) => c_.copy(time = Option(f_)))

    def optionalTime
      : _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.google.protobuf.timestamp.Timestamp]] =
      field(_.time)((c_, f_) => c_.copy(time = f_))

    def numTxs: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] =
      field(_.numTxs)((c_, f_) => c_.copy(numTxs = f_))

    def totalTxs: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] =
      field(_.totalTxs)((c_, f_) => c_.copy(totalTxs = f_))

    def lastBlockId: _root_.scalapb.lenses.Lens[UpperPB, proto3.tendermint.BlockID] =
      field(_.getLastBlockId)((c_, f_) => c_.copy(lastBlockId = Option(f_)))

    def optionalLastBlockId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[proto3.tendermint.BlockID]] =
      field(_.lastBlockId)((c_, f_) => c_.copy(lastBlockId = f_))

    def lastCommitHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.lastCommitHash)((c_, f_) => c_.copy(lastCommitHash = f_))

    def dataHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.dataHash)((c_, f_) => c_.copy(dataHash = f_))

    def validatorsHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.validatorsHash)((c_, f_) => c_.copy(validatorsHash = f_))

    def nextValidatorsHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.nextValidatorsHash)((c_, f_) => c_.copy(nextValidatorsHash = f_))

    def consensusHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.consensusHash)((c_, f_) => c_.copy(consensusHash = f_))

    def appHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.appHash)((c_, f_) => c_.copy(appHash = f_))

    def lastResultsHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.lastResultsHash)((c_, f_) => c_.copy(lastResultsHash = f_))

    def evidenceHash: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.evidenceHash)((c_, f_) => c_.copy(evidenceHash = f_))

    def proposerAddress: _root_.scalapb.lenses.Lens[UpperPB, _root_.com.google.protobuf.ByteString] =
      field(_.proposerAddress)((c_, f_) => c_.copy(proposerAddress = f_))
  }
  final val VERSION_FIELD_NUMBER = 1
  final val CHAIN_ID_FIELD_NUMBER = 2
  final val HEIGHT_FIELD_NUMBER = 3
  final val TIME_FIELD_NUMBER = 4
  final val NUM_TXS_FIELD_NUMBER = 5
  final val TOTAL_TXS_FIELD_NUMBER = 6
  final val LAST_BLOCK_ID_FIELD_NUMBER = 7
  final val LAST_COMMIT_HASH_FIELD_NUMBER = 8
  final val DATA_HASH_FIELD_NUMBER = 9
  final val VALIDATORS_HASH_FIELD_NUMBER = 10
  final val NEXT_VALIDATORS_HASH_FIELD_NUMBER = 11
  final val CONSENSUS_HASH_FIELD_NUMBER = 12
  final val APP_HASH_FIELD_NUMBER = 13
  final val LAST_RESULTS_HASH_FIELD_NUMBER = 14
  final val EVIDENCE_HASH_FIELD_NUMBER = 15
  final val PROPOSER_ADDRESS_FIELD_NUMBER = 16
}
