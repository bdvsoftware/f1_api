package com.f1api.kafka.messaging.data;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarMotionData implements Serializable {
    
    @JsonProperty("m_worldPositionX")
    private BigDecimal worldPositionX; 

    @JsonProperty("m_worldPositionY")
    private BigDecimal worldPositionY; 

    @JsonProperty("m_worldPositionZ")
    private BigDecimal worldPositionZ; 

    @JsonProperty("m_worldVelocityX")
    private BigDecimal worldVelocityX;

    @JsonProperty("m_worldVelocityY")
    private BigDecimal worldVelocityY;

    @JsonProperty("m_worldVelocityZ")
    private BigDecimal worldVelocityZ; 

    @JsonProperty("m_worldForwardDirX")
    private Short worldForwardDirX;

    @JsonProperty("m_worldForwardDirY")
    private Short worldForwardDirY;

    @JsonProperty("m_worldForwardDirZ")
    private Short worldForwardDirZ;

    @JsonProperty("m_worldRightDirX")
    private Short worldRightDirX; 

    @JsonProperty("m_worldRightDirY")
    private Short worldRightDirY;

    @JsonProperty("m_worldRightDirZ")
    private Short worldRightDirZ;

    @JsonProperty("m_gForceLateral")
    private BigDecimal gForceLateral;

    @JsonProperty("m_gForceLongitudinal")
    private BigDecimal gForceLongitudinal;

    @JsonProperty("m_gForceVertical")
    private BigDecimal gForceVertical;

    @JsonProperty("m_yaw")
    private BigDecimal yaw;

    @JsonProperty("m_pitch")
    private BigDecimal pitch;

    @JsonProperty("m_roll")
    private BigDecimal roll;
}
