package com.f1api.kafka.messaging.packet.types;

import java.math.BigDecimal;

import com.f1api.domain.CarCorner;
import com.f1api.kafka.messaging.packet.master.Packet;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacketMotionEx implements Packet{

    @JsonProperty("m_header")
    private PacketHeader packetHeader;

    @JsonProperty("m_suspensionPosition")
    private BigDecimal[] suspensionPosition;

    @JsonProperty("m_suspensionVelocity")
    private BigDecimal[] suspensionVelocity;

    @JsonProperty("m_suspensionAcceleration")
    private BigDecimal[] suspensionAcceleration;

    @JsonProperty("m_wheelSpeed")
    private BigDecimal[] wheelSpeed;

    @JsonProperty("m_wheelSlipRatio")
    private BigDecimal[] wheelSlipRatio;

    @JsonProperty("m_wheelSlipAngle")
    private BigDecimal[] wheelSlipAngle;

    @JsonProperty("m_wheelLatForce")
    private BigDecimal[] wheelLatForce;

    @JsonProperty("m_wheelLongForce")
    private BigDecimal[] wheelLongForce;

    @JsonProperty("m_wheelVertForce")
    private BigDecimal[] wheelVertForce;

    @JsonProperty("m_heightOfCOGAboveGround")
    private BigDecimal heightOfCOGAboveGround;

    @JsonProperty("m_localVelocityX")
    private BigDecimal localVelocityX;

    @JsonProperty("m_localVelocityY")
    private BigDecimal localVelocityY;

    @JsonProperty("m_localVelocityZ")
    private BigDecimal localVelocityZ;

    @JsonProperty("m_angularVelocityX")
    private BigDecimal angularVelocityX;

    @JsonProperty("m_angularVelocityY")
    private BigDecimal angularVelocityY;

    @JsonProperty("m_angularVelocityZ")
    private BigDecimal angularVelocityZ;

    @JsonProperty("m_angularAccelerationX")
    private BigDecimal angularAccelerationX;

    @JsonProperty("m_angularAccelerationY")
    private BigDecimal angularAccelerationY;

    @JsonProperty("m_angularAccelerationZ")
    private BigDecimal angularAccelerationZ;

    @JsonProperty("m_frontWheelsAngle")
    private BigDecimal frontWheelsAngle;
}
