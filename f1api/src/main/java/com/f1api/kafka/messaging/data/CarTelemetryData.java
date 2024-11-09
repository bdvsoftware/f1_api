package com.f1api.kafka.messaging.data;

import java.io.Serializable;
import java.math.BigDecimal;

import com.f1api.domain.Corner;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarTelemetryData implements Serializable{
    
    @JsonProperty("m_speed")
    private Integer speed; 

    @JsonProperty("m_throttle")
    private BigDecimal throttle; 

    @JsonProperty("m_steer")
    private BigDecimal steer;

    @JsonProperty("m_brake")
    private BigDecimal brake;

    @JsonProperty("m_clutch")
    private Integer clutch;

    @JsonProperty("m_gear")
    private Short gear;

    @JsonProperty("m_engineRPM")
    private Integer engineRPM; 

    @JsonProperty("m_drs")
    private Boolean drs; 

    @JsonProperty("m_revLightsPercent")
    private BigDecimal revLightsPercent;

    @JsonProperty("m_revLightsBitValue")
    private Integer revLightsBitValue;

    @JsonProperty("m_brakesTemperature")
    private Corner brakesTemperature;

    @JsonProperty("m_tyresSurfaceTemperature")
    private Corner tyresSurfaceTemperature;

    @JsonProperty("m_tyresInnerTemperature")
    private Corner tyresInnerTemperature;

    @JsonProperty("m_engineTemperature")
    private Integer engineTemperature; 

    @JsonProperty("m_tyresPressure")
    private Corner tyresPressure; 

    @JsonProperty("m_surfaceType")
    private Corner surfaceType;
}
