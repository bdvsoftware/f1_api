package com.f1api.kafka.messaging.packet;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.f1api.kafka.messaging.packet.master.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacketReceived implements Serializable {
    private Short id;
    private Packet data;
}
