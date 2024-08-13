package com.f1api.repository.mongo.packet;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.packet.lapdata.PacketLapDataEntity;

public interface PacketLapDataMongoRepository extends MongoRepository<PacketLapDataEntity, Long>{
    
}
