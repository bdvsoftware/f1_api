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

    @JsonSubTypes({
        @JsonSubTypes.Type(value = ClassA.class, name = Constants.PacketTypes.MOTION_PACKET)
    })
    private Packet data;
}
