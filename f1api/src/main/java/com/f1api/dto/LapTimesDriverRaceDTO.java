package com.f1api.dto;

import java.util.List;

import lombok.Data;

@Data
public class LapTimesDriverRaceDTO {
    
    private Short driverId;

    private String driverName;

    private Long raceId;

    private String gp;

    private Integer year;

    private List<LapTimeDTO> lapTimes;
}
