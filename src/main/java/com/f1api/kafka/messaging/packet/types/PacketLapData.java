package com.f1api.kafka.messaging.packet.types;

import java.math.BigInteger;
import java.util.List;

import com.f1api.kafka.messaging.data.LapData;
import com.f1api.kafka.messaging.packet.master.Packet;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacketLapData implements Packet{

    @JsonProperty("m_header")
    private PacketHeader packetHeader;
    @JsonProperty("m_lapData")
    private List<LapData> lapData;
    @JsonProperty("m_timeTrialPBCarIdx")
    private BigInteger timeTrialPBCarIdx;
    @JsonProperty("m_timeTrialRivalCarIdx")
    private BigInteger timeTrialRivalCarIdx;
}
