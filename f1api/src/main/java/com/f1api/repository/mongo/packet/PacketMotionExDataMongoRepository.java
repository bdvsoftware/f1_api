package com.f1api.repository.mongo.packet;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.packet.motionex.PacketMotionExDataEntity;

public interface PacketMotionExDataMongoRepository extends MongoRepository<PacketMotionExDataEntity, UUID>{
    
}
