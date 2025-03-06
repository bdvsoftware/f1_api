package com.f1api.kafka.messaging.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarStatusData implements Serializable {
    
    @JsonProperty("m_tractionControl")
    private Short tractionControl;

    @JsonProperty("m_antiLockBrakes")
    private Boolean antiLockBrakes;

    @JsonProperty("m_fuelMix")
    private Short fuelMix;

    @JsonProperty("m_frontBrakeBias")
    private Short frontBrakeBias;

    @JsonProperty("m_pitLimiterStatus")
    private Boolean pitLimiterStatus;

    @JsonProperty("m_fuelInTank")
    private Integer fuelInTank;

    @JsonProperty("m_fuelCapacity")
    private Integer fuelCapacity;

    @JsonProperty("m_fuelRemainingLaps")
    private Integer fuelRemainingLaps;

    @JsonProperty("m_maxRPM")
    private Integer maxRPM;

    @JsonProperty("m_idleRPM")
    private Integer idleRPM;

    @JsonProperty("m_maxGears")
    private Short maxGears;

    @JsonProperty("m_drsAllowed")
    private Boolean drsAllowed;

    @JsonProperty("m_drsActivationDistance")
    private Integer drsActivationDistance;

    @JsonProperty("m_actualTyreCompound")
    private Short actualTyreCompound;

    @JsonProperty("m_visualTyreCompound")
    private Short visualTyreCompound;

    @JsonProperty("m_tyresAgeLaps")
    private Short tyresAgeLaps;

    @JsonProperty("m_vehicleFiaFlags")
    private Short vehicleFiaFlags;

    @JsonProperty("m_enginePowerICE")
    private Integer enginePowerICE;

    @JsonProperty("m_enginePowerMGUK")
    private Integer enginePowerMGUK;

    @JsonProperty("m_ersStoreEnergy")
    private Integer ersStoreEnergy;

    @JsonProperty("m_ersDeployMode")
    private Short ersDeployMode;

    @JsonProperty("m_ersHarvestedThisLapMGUK")
    private Integer ersHarvestedThisLapMGUK;

    @JsonProperty("m_ersHarvestedThisLapMGUH")
    private Integer ersHarvestedThisLapMGUH;

    @JsonProperty("m_ersDeployedThisLap")
    private Integer ersDeployedThisLap;

    @JsonProperty("m_networkPaused")
    private Integer networkPaused;
}
