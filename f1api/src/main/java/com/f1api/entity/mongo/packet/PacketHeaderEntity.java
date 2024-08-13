package com.f1api.entity.mongo.packet;

import java.math.BigDecimal;
import java.math.BigInteger;

public record PacketHeaderEntity (
    Integer m_packetFormat,
    Short m_gameYear,
    BigDecimal m_gameMajorVersion,
    BigDecimal m_gameMinorVersion,
    Short m_packetVersion,
    Short m_packetId,
    BigInteger m_sessionUID,
    BigDecimal m_sessionTime,
    BigInteger m_frameIdentifier,
    BigInteger m_overallFrameIdentifier,
    BigInteger m_playerCarIndex,
    BigInteger m_secondaryPlayerCarIndex
) {}
