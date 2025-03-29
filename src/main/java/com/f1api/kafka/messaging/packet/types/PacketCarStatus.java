package com.f1api.kafka.messaging.packet.types;

import java.util.List;

import com.f1api.kafka.messaging.data.CarStatusData;
import com.f1api.kafka.messaging.packet.master.Packet;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacketCarStatus implements Packet {
    
    @JsonProperty("m_header")
    private PacketHeader packetHeader;

    @JsonProperty("m_carStatusData")
    private List<CarStatusData> carStatusData;
}
