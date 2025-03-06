package com.f1api.repository.mongo.packet;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.packet.carsetup.PacketCarSetupDataEntity;


public interface PacketCarSetupDataMongoRepository extends MongoRepository<PacketCarSetupDataEntity, UUID>{
    
}
