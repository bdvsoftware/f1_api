package com.f1api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.f1api.entity.Circuit;
import com.f1api.service.CircuitService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController("/api/circuits")
@RequiredArgsConstructor
public class CirctuirController {

    private final CircuitService circuitService;

    @GetMapping("/all")
    public List<Circuit> getMethodName(@RequestParam String param) {
        return circuitService.getAll();
    }
    
}
