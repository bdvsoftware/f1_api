package com.f1api.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.f1api.entity.mongo.LapTimeDriverMongo;

public interface LapTimeDriverMongoRepository extends MongoRepository<LapTimeDriverMongo, Long>{
    
}
