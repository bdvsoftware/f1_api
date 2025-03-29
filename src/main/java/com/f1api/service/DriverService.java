package com.f1api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.f1api.entity.Driver;
import com.f1api.repository.DriverRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public List<Driver> findAllDrivers(){
        return this.driverRepository.findAll();
    }
}
