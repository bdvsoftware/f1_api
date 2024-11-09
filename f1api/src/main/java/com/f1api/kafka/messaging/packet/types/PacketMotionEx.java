package com.f1api.kafka.messaging.packet.types;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.f1api.domain.CarCorner;
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
    private CarCorner suspensionPosition;

    @JsonProperty("m_suspensionVelocity")
    private CarCorner suspensionVelocity;

    @JsonProperty("m_suspensionAcceleration")
    private CarCorner suspensionAcceleration;

    @JsonProperty("m_wheelSpeed")
    private CarCorner wheelSpeed;

    @JsonProperty("m_wheelSlipRatio")
    private CarCorner wheelSlipRatio;

    @JsonProperty("m_wheelSlipAngle")
    private CarCorner wheelSlipAngle;

    @JsonProperty("m_wheelLatForce")
    private CarCorner wheelLatForce;

    @JsonProperty("m_wheelLongForce")
    private CarCorner wheelLongForce;

    @JsonProperty("m_wheelVertForce")
    private CarCorner wheelVertForce;

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
