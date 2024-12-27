package com.f1api.entity.mongo.packet.motion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;

import jakarta.persistence.Id;

@Document("packet_motion_data")
public record PacketMotionDataEntity (
    @Id UUID id,
    PacketHeaderEntity packetHeaderEntity,
    List<CarMotionDataEntity> carMotionData,
    LocalDateTime createdAt
) {}
