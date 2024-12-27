package com.f1api.entity.mongo.packet.motion;

import java.math.BigDecimal;

public record CarMotionDataEntity (
    BigDecimal worldPositionX,
    BigDecimal worldPositionY,
    BigDecimal worldPositionZ,
    BigDecimal worldVelocityX,
    BigDecimal worldVelocityY,
    BigDecimal worldVelocityZ,
    Short worldForwardDirX,
    Short worldForwardDirY,
    Short worldForwardDirZ,
    Short worldRightDirX,
    Short worldRightDirY,
    Short worldRightDirZ,
    BigDecimal gForceLateral,
    BigDecimal gForceLongitudinal,
    BigDecimal gForceVertical,
    BigDecimal yaw,
    BigDecimal pitch,
    BigDecimal roll
) {}
