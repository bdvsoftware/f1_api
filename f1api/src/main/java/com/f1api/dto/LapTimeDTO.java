package com.f1api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LapTimeDTO {
   
    private Long lapTimeId;

    private Short driverId;

    private Long raceId;

    private Short lap;

    private Short position;

    private String time;

    private Long milliseconds;
}
