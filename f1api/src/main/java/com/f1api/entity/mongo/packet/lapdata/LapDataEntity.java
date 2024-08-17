package com.f1api.entity.mongo.packet.lapdata;

import java.math.BigInteger;
import java.math.BigDecimal;

public record LapDataEntity(
    BigInteger m_lastLapTimeInMS,
    BigInteger m_currentLapTimeInMS,
    BigInteger m_sector1TimeInMS,
    Integer m_sector1TimeMinutes,
    BigInteger m_sector2TimeInMS,
    Integer m_sector2TimeMinutes,
    BigInteger m_deltaToCarInFrontInMS,
    BigInteger m_deltaToRaceLeaderInMS,
    BigDecimal m_lapDistance,
    BigDecimal m_totalDistance,
    BigDecimal m_safetyCarDelta,
    Integer m_carPosition,
    Integer m_currentLapNum,
    Integer m_pitStatus,
    Integer m_numPitStops,
    Integer m_sector,
    Boolean m_currentLapInvalid,
    Integer m_penalties,
    Integer m_totalWarnings,
    Integer m_cornerCuttingWarnings,
    Integer m_numUnservedDriveThroughPens,
    Integer m_numUnservedStopGoPens,
    Integer m_gridPosition,
    Integer m_driverStatus,
    Integer m_resultStatus,
    Integer m_pitLaneTimerActive,
    BigInteger m_pitLaneTimeInLaneInMS,
    BigInteger m_pitStopTimerInMS,
    Integer m_pitStopShouldServePen
) {}
