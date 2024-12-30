package com.f1api.repository.mongo.packet;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import java.util.List;


public interface PacketMotionDataMongoRepository extends MongoRepository<PacketMotionDataEntity, UUID>{
    
    @Query(value = "{ 'stintName': ?0 }")
    List<PacketMotionDataEntity> findAllLatAccByStintName(String stintName);
}
