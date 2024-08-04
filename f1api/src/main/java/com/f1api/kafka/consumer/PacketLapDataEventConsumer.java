package com.f1api.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.f1api.service.packet.PacketLapDataEventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PacketLapDataEventConsumer {

    public static final String TOPIC = "mytelemetry.udp.message.lap_data.created";

    private final PacketLapDataEventService service;

    @KafkaListener(topics = TOPIC)
    public void consumeMessage(ConsumerRecord<String, Object> data){
        try{
            log.info(data.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
