package com.f1api.entity.mongo.packet.lapdata;

import java.math.BigInteger;
import java.math.BigDecimal;

public record LapDataEntity(
    BigInteger m_lastLapTimeInMS,
    BigInteger m_currentLapTimeInMS,
    BigInteger m_sector1TimeInMS,
    Short m_sector1TimeMinutes,
    BigInteger m_sector2TimeInMS,
    Short m_sector2TimeMinutes,
    BigInteger m_deltaToCarInFrontInMS,
    BigInteger m_deltaToRaceLeaderInMS,
    BigDecimal m_lapDistance,
    BigDecimal m_totalDistance,
    BigDecimal m_safetyCarDelta,
    Short m_carPosition,
    Short m_currentLapNum,
    Short m_pitStatus,
    Short m_numPitStops,
    Short m_sector,
    Boolean m_currentLapInvalid,
    Short m_penalties,
    Short m_totalWarnings,
    Short m_cornerCuttingWarnings,
    Short m_numUnservedDriveThroughPens,
    Short m_numUnservedStopGoPens,
    Short m_gridPosition,
    Short m_driverStatus,
    Short m_resultStatus,
    Short m_pitLaneTimerActive,
    BigInteger m_pitLaneTimeInLaneInMS,
    BigInteger m_pitStopTimerInMS,
    Short m_pitStopShouldServePen
) {}
