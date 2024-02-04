package com.f1api.kafka.producer.laptime;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.f1api.dto.LapTimesDriverRaceDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LapTimesDriverRaceRequestEvent {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "f1api.1.event.lap-time-driver-race.request";

    public void sendMessage(LapTimesDriverRaceDTO dto){
        kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), dto);
    }
}
