package com.f1api.repository.mongo.stint;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.stint.StintEntity;

public interface StintMongoRepository extends MongoRepository<StintEntity, UUID>{

    Boolean existsByStintName(String stintName);

    @Aggregation(pipeline = { "{ $group: { _id: \"$stintName\" } }" })
    List<String> findDistinctNames();
    
}
