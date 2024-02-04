package com.f1api.service;

import org.springframework.stereotype.Service;

import com.f1api.dto.LapTimesDriverRaceDTO;
import com.f1api.repository.LapTimesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LapTimeService {
    
    private final LapTimesRepository lapTimesRepository;

    public LapTimesDriverRaceDTO getLapTimesDriverRace(Short driverId, Short raceId){
        LapTimesDriverRaceDTO lapTimesDriverRaceDTO = new LapTimesDriverRaceDTO();
        lapTimesDriverRaceDTO.setDriverId(driverId);
        lapTimesDriverRaceDTO.setRaceId(raceId);
        lapTimesDriverRaceDTO.setLapTimes(this.lapTimesRepository.findLapTimerDriverRace(driverId, raceId));
        return lapTimesDriverRaceDTO;
    }
}
