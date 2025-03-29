package com.f1api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.f1api.repository.mongo.stint.StintMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StintService {

    private final StintMongoRepository stintRepository;

    public List<String> findAllStints(){
        return stintRepository.findDistinctNames();
    }
    
}
