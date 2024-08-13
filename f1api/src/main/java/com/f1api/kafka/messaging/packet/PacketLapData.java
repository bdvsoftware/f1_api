package com.f1api.kafka.messaging.packet;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.f1api.kafka.messaging.data.LapData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacketLapData implements Serializable{

    @JsonProperty("m_header")
    private PacketHeader m_header;
    @JsonProperty("m_lapData")
    private List<LapData> m_lapData;
    @JsonProperty("m_timeTrialPBCarIdx")
    private BigInteger m_timeTrialPBCarIdx;
    @JsonProperty("m_timeTrialRivalCarIdx")
    private BigInteger m_timeTrialRivalCarIdx;
}
