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
public class CarSetupData implements Serializable{
    @JsonProperty("m_frontWing")
    private Integer frontWing;

    @JsonProperty("m_rearWing")
    private Integer rearWing;

    @JsonProperty("m_onThrottle")
    private Integer onThrottle;

    @JsonProperty("m_offThrottle")
    private Integer offThrottle;

    @JsonProperty("m_frontCamber")
    private BigDecimal frontCamber;

    @JsonProperty("m_rearCamber")
    private BigDecimal rearCamber;

    @JsonProperty("m_frontToe")
    private BigDecimal frontToe;

    @JsonProperty("m_rearToe")
    private BigDecimal rearToe;

    @JsonProperty("m_frontSuspension")
    private Integer frontSuspension;

    @JsonProperty("m_rearSuspension")
    private Integer rearSuspension;

    @JsonProperty("m_frontAntiRollBar")
    private Integer frontAntiRollBar;

    @JsonProperty("m_rearAntiRollBar")
    private Integer rearAntiRollBar;

    @JsonProperty("m_frontSuspensionHeight")
    private Integer frontSuspensionHeight;

    @JsonProperty("m_rearSuspensionHeight")
    private Integer rearSuspensionHeight;

    @JsonProperty("m_brakePressure")
    private Integer brakePressure;

    @JsonProperty("m_brakeBias")
    private Integer brakeBias;

    @JsonProperty("m_rearLeftTyrePressure")
    private BigDecimal rearLeftTyrePressure;

    @JsonProperty("m_rearRightTyrePressure")
    private BigDecimal rearRightTyrePressure;

    @JsonProperty("m_frontLeftTyrePressure")
    private BigDecimal frontLeftTyrePressure;

    @JsonProperty("m_frontRightTyrePressure")
    private BigDecimal frontRightTyrePressure;

    @JsonProperty("m_ballast")
    private Integer ballast;

    @JsonProperty("m_fuelLoad")
    private BigDecimal fuelLoad;
}
