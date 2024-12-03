package com.f1api.entity.mongo.packet.cartelemetry;

import java.math.BigDecimal;

public record CarTelemetryDataEntity (
    Integer speed, 
    BigDecimal throttle, 
    BigDecimal steer,
    BigDecimal brake,
    Integer clutch,
    Short gear,
    Integer engineRPM, 
    Boolean drs, 
    BigDecimal revLightsPercent,
    Integer revLightsBitValue,
    BigDecimal[] brakesTemperature,
    BigDecimal[] tyresSurfaceTemperature,
    BigDecimal[] tyresInnerTemperature,
    Integer engineTemperature, 
    BigDecimal[] tyresPressure, 
    BigDecimal[] surfaceType
){}
