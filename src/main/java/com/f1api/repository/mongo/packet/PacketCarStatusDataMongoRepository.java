package com.f1api.repository.mongo.packet;

import com.f1api.entity.mongo.packet.carstatus.PacketCarStatusDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface PacketCarStatusDataMongoRepository extends MongoRepository<PacketCarStatusDataEntity, UUID>{

    List<PacketCarStatusDataEntity> findByStintName(String stintName);
    
}
