package com.f1api.repository.mongo.packet;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

import com.f1api.entity.mongo.packet.cartelemetry.PacketCarTelemetryDataEntity;

public interface PacketCarTelemetryDataMongoRepository extends MongoRepository<PacketCarTelemetryDataEntity, UUID>{
    
}
