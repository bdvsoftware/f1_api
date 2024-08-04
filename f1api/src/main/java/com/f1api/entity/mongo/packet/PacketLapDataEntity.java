package com.f1api.entity.mongo.packet;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document("packet_lap_data")
public record PacketLapDataEntity (
    @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id,
    String 
){}
