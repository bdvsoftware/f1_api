package com.f1api.entity.mongo.packet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public record PacketHeaderEntity (
    String m_packetFormat,
    Short m_gameYear,
    BigDecimal m_gameMajorVersion,
    BigDecimal m_gameMinorVersion,
    Short m_packetVersion,
    Short m_packetId,
    BigInteger m_sessionUID,
    Date m_sessionTime,
    BigInteger m_frameIdentifier,
    BigInteger m_overallFrameIdentifier,
    Short m_playerCarIndex,
    Short m_secondaryPlayerCarIndex
) {}
