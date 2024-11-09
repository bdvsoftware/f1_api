package com.f1api.kafka.messaging.packet;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.f1api.kafka.messaging.packet.master.*;
import com.f1api.kafka.messaging.packet.types.PacketCarTelemetry;
import com.f1api.kafka.messaging.packet.types.PacketLapData;
import com.f1api.kafka.messaging.packet.types.PacketMotion;
import com.f1api.kafka.messaging.packet.types.PacketMotionEx;
import com.f1api.util.Constants;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PacketReceived implements Serializable {
    private Short id;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "packetType")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = PacketMotion.class, name = Constants.PacketTypes.MOTION_PACKET),
        @JsonSubTypes.Type(value = PacketLapData.class, name = Constants.PacketTypes.LAP_DATA_PACKET),
        @JsonSubTypes.Type(value = PacketCarTelemetry.class, name = Constants.PacketTypes.CAR_TELEMETRY_PACKET),
        @JsonSubTypes.Type(value = PacketMotionEx.class, name = Constants.PacketTypes.MOTION_EX_PACKET)
    })
    private Packet data;
}
