package com.f1api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.f1api.entity.mongo.LapTimeDriverMongo;

import lombok.Data;

@Data
public class LapTimesDriverRaceDTO {
    
    private Short driverId;

    private String driverName;

    private Long raceId;

    private String gp;

    private Integer year;

    private List<LapTimeDTO> lapTimes;

    public static List<LapTimeDriverMongo> toRecord(List<LapTimesDriverRaceDTO> list){
        return list.stream().map(item -> LapTimesDriverRaceDTO.convertToMongo(item)).collect(Collectors.toList());
    }
    
    public static LapTimeDriverMongo convertToMongo(LapTimesDriverRaceDTO item){
        return new LapTimeDriverMongo(item.getRaceId(), item.driverName, item.raceId, item.gp, item.getDriverId(), LapTimeDTO.toRecord(item.getLapTimes()));
    }
}


