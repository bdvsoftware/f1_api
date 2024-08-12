package com.f1api.entity.mongo.packet.lapdata;

import org.springframework.data.mongodb.core.mapping.Document;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document("packet_lap_data")
public record PacketLapDataEntity (
    @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id,
    PacketHeaderEntity packetHeaderEntity,
    LapDataEntity lapData
){}
