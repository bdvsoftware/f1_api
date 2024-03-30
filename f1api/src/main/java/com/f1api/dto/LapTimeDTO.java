package com.f1api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.f1api.entity.mongo.LapTimeMongo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LapTimeDTO {
   
    private Long lapTimeId;

    private Short lap;

    private Short position;

    private String time;

    private Long milliseconds;

    public List<LapTimeMongo> toRecord(List<LapTimeDTO> list){
        return list.stream()
        .map(item -> converToMongo(item))
        .collect(Collectors.toList());
    }

    public LapTimeMongo converToMongo(LapTimeDTO item){
        return new LapTimeMongo(item.lapTimeId, item.lap, item.position, item.time, item.milliseconds); 
    }
}

