package com.f1api.kafka.messaging.packet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PacketHeader implements Serializable{
    private Integer m_packetFormat; 
    private Integer m_gameYear;  
    private Integer m_gameMajorVersion;
    private Integer m_gameMinorVersion;
    private Integer m_packetVersion; 
    private Integer m_packetId; 
    private BigInteger m_sessionUID;
    private BigDecimal m_sessionTime;
    private BigInteger m_frameIdentifier; 
    private BigInteger m_overallFrameIdentifier; 
    private Integer m_playerCarIndex; 
    private Integer m_secondaryPlayerCarIndex;
}
