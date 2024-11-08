package com.f1api.kafka.messaging.packet;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.f1api.kafka.messaging.packet.master.*;
import com.f1api.util.Constants;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacketReceived implements Serializable {
    private Short id;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "packetType")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = ClassA.class, name = Constants.PacketTypes.MOTION_PACKET),
        @JsonSubTypes.Type(value = ClassA.class, name = Constants.PacketTypes.LAP_DATA_PACKET),
        @JsonSubTypes.Type(value = ClassA.class, name = Constants.PacketTypes.CAR_TELEMETRY_PACKET),
        @JsonSubTypes.Type(value = ClassA.class, name = Constants.PacketTypes.MOTION_EX_PACKET)
    })
    private Packet data;
}
