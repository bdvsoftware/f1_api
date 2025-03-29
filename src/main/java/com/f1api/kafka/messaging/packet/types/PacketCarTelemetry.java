package com.f1api.kafka.messaging.packet.types;

import java.util.List;

import com.f1api.kafka.messaging.data.CarTelemetryData;
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
public class PacketCarTelemetry implements Packet{
    
    @JsonProperty("m_header")
    private PacketHeader packetHeader;

    @JsonProperty("m_carTelemetryData")
    private List<CarTelemetryData> carTelemetryData;

    @JsonProperty("m_mfdPanelIndex")
    private Integer mfdPanelIndex;

    @JsonProperty("m_mfdPanelIndexSecondaryPlayer")
    private Integer mfdPanelIndexSecondaryPlayer;

    @JsonProperty("m_suggestedGear")
    private Short suggestedGear;
}
