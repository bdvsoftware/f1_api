package com.f1api.dto;

import java.util.List;

import lombok.Data;

@Data
public class LapTimesDriverRaceDTO {
    
    private Short driverId;

    private Short raceId;

    private List<LapTimeDTO> lapTimes;
}
