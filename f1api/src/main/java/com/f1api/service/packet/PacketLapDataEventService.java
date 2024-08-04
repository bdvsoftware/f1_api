package com.f1api.service.packet;

import org.springframework.stereotype.Service;

import com.f1api.kafka.messaging.packet.PacketLapData;

@Service
public class PacketLapDataEventService {

    public void save(PacketLapData data){
        System.out.println(data);
    }
}
