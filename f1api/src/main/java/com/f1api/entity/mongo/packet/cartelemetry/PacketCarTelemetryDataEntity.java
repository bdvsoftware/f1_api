package com.f1api.entity.mongo.packet.cartelemetry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;

import jakarta.persistence.Id;

@Document("packet_car_telemetry_data")
public record PacketCarTelemetryDataEntity (
    @Id UUID id,
    String stintName,
    PacketHeaderEntity packetHeaderEntity,
    List<CarTelemetryDataEntity> carTelemetryData,
    Integer mfdPanelIndex,
    Integer mfdPanelIndexSecondaryPlayer,
    Short suggestedGear,
    LocalDateTime createdAt
){}
