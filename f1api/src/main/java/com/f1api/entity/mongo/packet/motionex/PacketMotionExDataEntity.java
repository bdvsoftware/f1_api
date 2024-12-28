package com.f1api.entity.mongo.packet.motionex;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;

import jakarta.persistence.Id;

@Document("packet_motion_ex_data")
public record PacketMotionExDataEntity (
    @Id UUID id,
    PacketHeaderEntity packetHeaderEntity,
    BigDecimal[] suspensionPosition,
    BigDecimal[] suspensionVelocity,
    BigDecimal[] suspensionAcceleration,
    BigDecimal[] wheelSpeed,
    BigDecimal[] wheelSlipRatio,
    BigDecimal[] wheelSlipAngle,
    BigDecimal[] wheelLatForce,
    BigDecimal[] wheelLongForce,
    BigDecimal heightOfCOGAboveGround,
    BigDecimal localVelocityX,
    BigDecimal localVelocityY,
    BigDecimal localVelocityZ,
    BigDecimal angularVelocityX,
    BigDecimal angularVelocityY,
    BigDecimal angularVelocityZ,
    BigDecimal angularAccelerationX,
    BigDecimal angularAccelerationY,
    BigDecimal angularAccelerationZ,
    BigDecimal frontWheelsAngle,
    BigDecimal[] wheelVertForce
) 
{}
