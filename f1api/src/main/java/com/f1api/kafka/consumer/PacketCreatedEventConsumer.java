package com.f1api.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.service.packet.PacketService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PacketCreatedEventConsumer {

    public static final String TOPIC = "mytelemetry.udp.packet.created";

    private final PacketService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC)
    public void consumeMessage(ConsumerRecord<String, Object> data) throws JsonProcessingException, JsonParseException{
        try{
            String json = mapper.writeValueAsString(data.value());
            PacketReceived packet = mapper.readValue(json , PacketReceived.class);
            service.process(packet);
            System.out.println("Processing package with id: "+packet.getId());
        }catch(JsonParseException e){
            e.printStackTrace();
        }
    }
}
