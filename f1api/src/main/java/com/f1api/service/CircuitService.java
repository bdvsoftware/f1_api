package com.f1api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.f1api.entity.Circuit;
import com.f1api.repository.CircuitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CircuitService {

    private final CircuitRepository circuitRepository;

    public List<Circuit> getAll(){
        List<Circuit> toret = circuitRepository.findAll();
        return toret;
    }
}
