package com.f1api.entity.mongo.packet.carsetup;

import java.math.BigDecimal;

public record CarSetupDataEntity(
    Integer frontWing,
    Integer rearWing,
    Integer onThrottle,
    Integer offThrottle,
    BigDecimal frontCamber,
    BigDecimal rearCamber,
    BigDecimal frontToe,
    BigDecimal rearToe,
    Integer frontSuspension,
    Integer rearSuspension,
    Integer frontAntiRollBar,
    Integer rearAntiRollBar,
    Integer frontSuspensionHeight,
    Integer rearSuspensionHeight,
    Integer brakePressure,
    Integer brakeBias,
    BigDecimal rearLeftTyrePressure,
    BigDecimal rearRightTyrePressure,
    BigDecimal frontLeftTyrePressure,
    BigDecimal frontRightTyrePressure,
    Integer ballast,
    BigDecimal fuelLoad
) {}
