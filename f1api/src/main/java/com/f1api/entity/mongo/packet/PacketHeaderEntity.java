package com.f1api.entity.mongo.packet;

import java.math.BigDecimal;
import java.math.BigInteger;

public record PacketHeaderEntity (
    Integer packetFormat,
    Short gameYear,
    BigDecimal gameMajorVersion,
    BigDecimal gameMinorVersion,
    Short packetVersion,
    Short packetId,
    BigInteger sessionUID,
    BigDecimal sessionTime,
    BigInteger frameIdentifier,
    BigInteger overallFrameIdentifier,
    BigInteger playerCarIndex,
    BigInteger secondaryPlayerCarIndex
) {}
