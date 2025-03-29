package com.f1api.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("lap_times_driver")
public record LapTimeDriverMongo (
    @Id Long id,
    String driverName,
    Long raceId,
    String gp,
    Short year,
    List<LapTimeMongo> lapTimes
){}
