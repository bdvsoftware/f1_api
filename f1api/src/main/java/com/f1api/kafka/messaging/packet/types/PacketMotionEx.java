package com.f1api.kafka.messaging.packet.types;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.f1api.domain.Corner;
import com.f1api.kafka.messaging.packet.master.Packet;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacketMotionEx implements Packet{

    @JsonProperty("m_packetHeader")
    private PacketHeader packetHeader;

    @JsonProperty("m_suspensionPosition")
    private Corner suspensionPosition;

    @JsonProperty("m_suspensionVelocity")
    private Corner suspensionVelocity;

    @JsonProperty("m_suspensionAcceleration")
    private Corner suspensionAcceleration;

    @JsonProperty("m_wheelSpeed")
    private Corner wheelSpeed;

    @JsonProperty("m_wheelSlipRatio")
    private Corner wheelSlipRatio;

    @JsonProperty("m_wheelSlipAngle")
    private Corner wheelSlipAngle;

    @JsonProperty("m_wheelLatForce")
    private Corner wheelLatForce;

    @JsonProperty("m_wheelLongForce")
    private Corner wheelLongForce;

    @JsonProperty("m_wheelVertForce")
    private Corner wheelVertForce;

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
