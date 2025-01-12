package com.f1api.entity.mongo.stint;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("stint")
public record StintEntity (
    @Id UUID id,
    String stintName,
    LocalDateTime createdAt
){}
