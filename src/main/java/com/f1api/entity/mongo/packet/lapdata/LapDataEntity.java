package com.f1api.entity.mongo.packet.lapdata;

import java.math.BigInteger;
import java.math.BigDecimal;

public record LapDataEntity(
    BigInteger lastLapTimeInMS,
    BigInteger currentLapTimeInMS,
    BigInteger sector1TimeInMS,
    Integer sector1TimeMinutes,
    BigInteger sector2TimeInMS,
    Integer sector2TimeMinutes,
    BigInteger deltaToCarInFrontInMS,
    BigInteger deltaToRaceLeaderInMS,
    BigDecimal lapDistance,
    BigDecimal totalDistance,
    BigDecimal safetyCarDelta,
    Integer carPosition,
    Integer currentLapNum,
    Integer pitStatus,
    Integer numPitStops,
    Integer sector,
    Boolean currentLapInvalid,
    Integer penalties,
    Integer totalWarnings,
    Integer cornerCuttingWarnings,
    Integer numUnservedDriveThroughPens,
    Integer numUnservedStopGoPens,
    Integer gridPosition,
    Integer driverStatus,
    Integer resultStatus,
    Integer pitLaneTimerActive
) {}
