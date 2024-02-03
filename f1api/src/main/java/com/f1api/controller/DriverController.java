package com.f1api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1api.entity.Driver;
import com.f1api.service.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/all")
    public List<Driver> getAllDrivers(){
        return this.driverService.findAllDrivers();
    }
    
}
