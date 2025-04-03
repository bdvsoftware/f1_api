package com.f1api.repository.mongo.packet;

import com.f1api.entity.mongo.packet.carsetup.PacketCarSetupDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;


public interface PacketCarSetupDataMongoRepository extends MongoRepository<PacketCarSetupDataEntity, UUID>{

    List<PacketCarSetupDataEntity> findByStintName(String stintName);
    
}
