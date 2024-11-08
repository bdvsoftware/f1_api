package com.f1api.kafka.messaging.packet.types;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacketHeader implements Serializable{
    private Integer m_packetFormat; 
    private Short m_gameYear;  
    private BigDecimal m_gameMajorVersion;
    private BigDecimal m_gameMinorVersion;
    private Short m_packetVersion; 
    private Short m_packetId; 
    private BigInteger m_sessionUID;
    private BigDecimal m_sessionTime;
    private BigInteger m_frameIdentifier; 
    private BigInteger m_overallFrameIdentifier; 
    private BigInteger m_playerCarIndex; 
    private BigInteger m_secondaryPlayerCarIndex;
}
