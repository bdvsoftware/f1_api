package com.f1api.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("lap_times")
public record LapTimeMongo (
    @Id Long lapTimeId,
    Short lap,
    Short position,
    String time,
    Long milliseconds
){}

