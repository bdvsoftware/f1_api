package com.f1api.kafka.messaging.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LapData implements Serializable{

    private BigInteger m_lastLapTimeInMS; // uint32 -> BigInteger
    private BigInteger m_currentLapTimeInMS; // uint32 -> BigInteger
    private Integer m_sector1TimeInMS; // uint16 -> Integer
    private Integer m_sector1TimeMinutes; // uint8 -> Integer
    private Integer m_sector2TimeInMS; // uint16 -> Integer
    private Integer m_sector2TimeMinutes; // uint8 -> Integer
    private Integer m_deltaToCarInFrontInMS; // uint16 -> Integer
    private Integer m_deltaToRaceLeaderInMS; // uint16 -> Integer
    private BigDecimal m_lapDistance; // float -> BigDecimal
    private BigDecimal m_totalDistance; // float -> BigDecimal
    private BigDecimal m_safetyCarDelta; // float -> BigDecimal
    private Integer m_carPosition; // uint8 -> Integer
    private Integer m_currentLapNum; // uint8 -> Integer
    private Integer m_pitStatus; // uint8 -> Integer
    private Integer m_numPitStops; // uint8 -> Integer
    private Integer m_sector; // uint8 -> Integer
    private Integer m_currentLapInvalid; // uint8 -> Integer
    private Integer m_penalties; // uint8 -> Integer
    private Integer m_totalWarnings; // uint8 -> Integer
    private Integer m_cornerCuttingWarnings; // uint8 -> Integer
    private Integer m_numUnservedDriveThroughPens; // uint8 -> Integer
    private Integer m_numUnservedStopGoPens; // uint8 -> Integer
    private Integer m_gridPosition; // uint8 -> Integer
    private Integer m_driverStatus; // uint8 -> Integer
    private Integer m_resultStatus; // uint8 -> Integer
    private Integer m_pitLaneTimerActive; // uint8 -> Integer
    private Integer m_pitLaneTimeInLaneInMS; // uint16 -> Integer
    private Integer m_pitStopTimerInMS; // uint16 -> Integer
    private Integer m_pitStopShouldServePen; // uint8 -> Integer
}
