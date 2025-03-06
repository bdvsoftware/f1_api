package com.f1api.repository.mongo.packet;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.packet.carstatus.PacketCarStatusDataEntity;

public interface PacketCarStatusDataMongoRepository extends MongoRepository<PacketCarStatusDataEntity, UUID>{
    
}
