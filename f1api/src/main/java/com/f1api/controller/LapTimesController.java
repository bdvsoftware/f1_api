package com.f1api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f1api.dto.LapTimesDriverRaceDTO;
import com.f1api.service.LapTimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/lapTimes")
@RequiredArgsConstructor
public class LapTimesController {

    private final LapTimeService lapTimeService;
    
    @GetMapping("laps-driver-race")
    public LapTimesDriverRaceDTO getLapTimesDriverRace(@RequestParam(name = "driverId") Short driverId, @RequestParam(name = "raceId") Long raceId){
        return this.lapTimeService.getLapTimesDriverRace(driverId, raceId);
    }
}
