package com.f1api.kafka.messaging.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LapData implements Serializable{
    
        @JsonProperty("m_lastLapTimeInMS")
        private BigInteger lastLapTimeInMS;
    
        @JsonProperty("m_currentLapTimeInMS")
        private BigInteger currentLapTimeInMS;
    
        @JsonProperty("m_sector1TimeInMS")
        private BigInteger sector1TimeInMS;
    
        @JsonProperty("m_sector1TimeMinutes")
        private Integer sector1TimeMinutes;
    
        @JsonProperty("m_sector2TimeInMS")
        private BigInteger sector2TimeInMS;
    
        @JsonProperty("m_sector2TimeMinutes")
        private Integer sector2TimeMinutes;
    
        @JsonProperty("m_deltaToCarInFrontInMS")
        private BigInteger deltaToCarInFrontInMS;
    
        @JsonProperty("m_deltaToRaceLeaderInMS")
        private BigInteger deltaToRaceLeaderInMS;
    
        @JsonProperty("m_lapDistance")
        private BigDecimal lapDistance;
    
        @JsonProperty("m_totalDistance")
        private BigDecimal totalDistance;
    
        @JsonProperty("m_safetyCarDelta")
        private BigDecimal safetyCarDelta;
    
        @JsonProperty("m_carPosition")
        private Integer carPosition;
    
        @JsonProperty("m_currentLapNum")
        private Integer currentLapNum;
    
        @JsonProperty("m_pitStatus")
        private Integer pitStatus;
    
        @JsonProperty("m_numPitStops")
        private Integer numPitStops;
    
        @JsonProperty("m_sector")
        private Integer sector;
    
        @JsonProperty("m_currentLapInvalid")
        private Boolean currentLapInvalid;
    
        @JsonProperty("m_penalties")
        private Integer penalties;
    
        @JsonProperty("m_totalWarnings")
        private Integer totalWarnings;
    
        @JsonProperty("m_cornerCuttingWarnings")
        private Integer cornerCuttingWarnings;
    
        @JsonProperty("m_numUnservedDriveThroughPens")
        private Integer numUnservedDriveThroughPens;
    
        @JsonProperty("m_numUnservedStopGoPens")
        private Integer numUnservedStopGoPens;
    
        @JsonProperty("m_gridPosition")
        private Integer gridPosition;
    
        @JsonProperty("m_driverStatus")
        private Integer driverStatus;
    
        @JsonProperty("m_resultStatus")
        private Integer resultStatus;
    
        @JsonProperty("m_pitLaneTimerActive")
        private Integer pitLaneTimerActive;   
}
