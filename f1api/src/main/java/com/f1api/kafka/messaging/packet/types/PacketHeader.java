package com.f1api.kafka.messaging.packet.types;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacketHeader implements Serializable{
    
    @JsonProperty("m_packetFormat")
    private Integer packetFormat;

    @JsonProperty("m_gameYear")
    private Short gameYear;

    @JsonProperty("m_gameMajorVersion")
    private BigDecimal gameMajorVersion;

    @JsonProperty("m_gameMinorVersion")
    private BigDecimal gameMinorVersion;

    @JsonProperty("m_packetVersion")
    private Short packetVersion;

    @JsonProperty("m_packetId")
    private Short packetId;

    @JsonProperty("m_sessionUID")
    private BigInteger sessionUID;

    @JsonProperty("m_sessionTime")
    private BigDecimal sessionTime;

    @JsonProperty("m_frameIdentifier")
    private BigInteger frameIdentifier;

    @JsonProperty("m_overallFrameIdentifier")
    private BigInteger overallFrameIdentifier;

    @JsonProperty("m_playerCarIndex")
    private BigInteger playerCarIndex;

    @JsonProperty("m_secondaryPlayerCarIndex")
    private BigInteger secondaryPlayerCarIndex;
}
