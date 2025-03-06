package com.f1api.entity.mongo.packet.carstatus;

public record CarStatusDataEntity (
    Short tractionControl,
    Boolean antiLockBrakes,
    Short fuelMix,
    Short frontBrakeBias,
    Boolean pitLimiterStatus,
    Integer fuelInTank,
    Integer fuelCapacity,
    Integer fuelRemainingLaps,
    Integer maxRPM,
    Integer idleRPM,
    Short maxGears,
    Boolean drsAllowed,
    Integer drsActivationDistance,
    Short actualTyreCompound,
    Short visualTyreCompound,
    Short tyresAgeLaps,
    Short vehicleFiaFlags,
    Integer enginePowerICE,
    Integer enginePowerMGUK,
    Integer ersStoreEnergy,
    Short ersDeployMode,
    Integer ersHarvestedThisLapMGUK,
    Integer ersHarvestedThisLapMGUH,
    Integer ersDeployedThisLap,
    Integer networkPaused
){}
