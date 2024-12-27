package com.f1api.service.packet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.motion.CarMotionDataEntity;
import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import com.f1api.kafka.messaging.data.CarMotionData;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketMotion;
import com.f1api.repository.mongo.packet.PacketMotionDataMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacketMotionDataService extends BaseService{
    
    private final PacketMotionDataMongoRepository repository;

    public void process(PacketReceived packet){
        this.repository.save(this.createEntity(packet));
    }

    private PacketMotionDataEntity createEntity(PacketReceived packet){
        var carMotionData = (PacketMotion) packet.getData();
        PacketMotionDataEntity entity = new PacketMotionDataEntity(
            UUID.randomUUID(),
            this.createHeaderEntity(carMotionData.getPacketHeader()),
            this.createCarMotionDataEntityList(carMotionData.getCarMotionData()),
            LocalDateTime.now()
        );
        return entity;
    }

    private List<CarMotionDataEntity> createCarMotionDataEntityList(List<CarMotionData> list){
        return list.stream()
        .map(item -> new CarMotionDataEntity(
            item.getWorldPositionX(),
            item.getWorldPositionY(),
            item.getWorldPositionZ(),
            item.getWorldVelocityX(),
            item.getWorldVelocityY(),
            item.getWorldVelocityZ(),
            item.getWorldForwardDirX(),
            item.getWorldForwardDirY(),
            item.getWorldForwardDirZ(),
            item.getWorldRightDirX(),
            item.getWorldRightDirY(),
            item.getWorldRightDirZ(),
            item.getGForceLateral(),
            item.getGForceLongitudinal(),
            item.getGForceVertical(),
            item.getYaw(),
            item.getPitch(),
            item.getRoll()
        ))
        .collect(Collectors.toList());
    }
}
