package com.f1api.entity.mongo;

import jakarta.persistence.Id;

public record LapTimeMongo (
    @Id Long lapTimeId,
    Short lap,
    Short position,
    String time,
    Long milliseconds
){}

