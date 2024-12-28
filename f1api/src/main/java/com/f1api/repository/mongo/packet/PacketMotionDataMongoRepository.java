package com.f1api.repository.mongo.packet;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.f1api.dto.LatAccDTO;
import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import java.util.List;


public interface PacketMotionDataMongoRepository extends MongoRepository<PacketMotionDataEntity, UUID>{
    
    @Query(value = "{ 'stintName': ?0 }", fields = "{ '_id': 1, 'carMotionData.gForceLateral': 1, 'packetHeaderEntity.sessionTime': 1 }")
    List<LatAccDTO> findAllLatAccByStintName(String stintName);
}
