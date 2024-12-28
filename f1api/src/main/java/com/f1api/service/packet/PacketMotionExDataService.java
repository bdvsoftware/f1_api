package com.f1api.service.packet;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.motionex.PacketMotionExDataEntity;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketMotionEx;
import com.f1api.repository.mongo.packet.PacketMotionExDataMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacketMotionExDataService extends BaseService{

    private final PacketMotionExDataMongoRepository repository;

    public void process(PacketReceived packet){
        this.repository.save(this.createEntity(packet));
    }

    private PacketMotionExDataEntity createEntity(PacketReceived packet){
        var carMotionExPacket = (PacketMotionEx) packet.getData();
        PacketMotionExDataEntity entity = new PacketMotionExDataEntity(
            UUID.randomUUID(),
            packet.getStintName(),
            this.createHeaderEntity(carMotionExPacket.getPacketHeader()),
            carMotionExPacket.getSuspensionPosition(),
            carMotionExPacket.getSuspensionVelocity(),
            carMotionExPacket.getSuspensionAcceleration(),
            carMotionExPacket.getWheelSpeed(),
            carMotionExPacket.getWheelSlipRatio(),
            carMotionExPacket.getWheelSlipAngle(),
            carMotionExPacket.getWheelLatForce(),
            carMotionExPacket.getWheelLongForce(),
            carMotionExPacket.getHeightOfCOGAboveGround(),
            carMotionExPacket.getLocalVelocityX(),
            carMotionExPacket.getAngularAccelerationY(),
            carMotionExPacket.getLocalVelocityZ(),
            carMotionExPacket.getAngularVelocityX(),
            carMotionExPacket.getAngularVelocityY(),
            carMotionExPacket.getAngularVelocityZ(),
            carMotionExPacket.getAngularAccelerationX(),
            carMotionExPacket.getAngularAccelerationY(),
            carMotionExPacket.getAngularAccelerationZ(),
            carMotionExPacket.getFrontWheelsAngle(),
            carMotionExPacket.getWheelVertForce()
        );
        return entity;
    }
    
}
