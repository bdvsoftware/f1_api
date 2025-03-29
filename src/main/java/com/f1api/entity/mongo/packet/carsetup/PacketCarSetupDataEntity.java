package com.f1api.entity.mongo.packet.carsetup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;

import jakarta.persistence.Id;

@Document("packet_car_setup_data")
public record PacketCarSetupDataEntity(
    @Id UUID id,
    String stintName,
    PacketHeaderEntity packetHeaderEntity,
    List<CarSetupDataEntity> carSetups,
    LocalDateTime createdAt
) {}
