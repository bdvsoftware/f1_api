package com.f1api.service;
import org.springframework.stereotype.Service;

import com.f1api.dto.LapTimesDriverRaceDTO;
import com.f1api.kafka.producer.laptime.LapTimesDriverRaceRequestEvent;
import com.f1api.repository.DriverRepository;
import com.f1api.repository.LapTimesRepository;
import com.f1api.repository.RaceRepository;
import com.f1api.entity.Driver;
import com.f1api.entity.Race;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LapTimeService {
    
    private final LapTimesRepository lapTimesRepository;

    private final DriverRepository driverRepository;

    private final RaceRepository raceRepository;

    private final LapTimesDriverRaceRequestEvent lapTimesDriverRaceRequestEvent;

    @Transactional
    public LapTimesDriverRaceDTO getLapTimesDriverRace(Short driverId, Long raceId){
        LapTimesDriverRaceDTO lapTimesDriverRaceDTO = new LapTimesDriverRaceDTO();
        Driver driverData = this.driverRepository.findById(driverId).get();
        lapTimesDriverRaceDTO.setDriverId(driverId);
        lapTimesDriverRaceDTO.setDriverName(driverData.getForename()+" "+driverData.getSurname());
        
        Race raceData = this.raceRepository.findById(raceId).get();
        lapTimesDriverRaceDTO.setRaceId(raceId);
        lapTimesDriverRaceDTO.setGp(raceData.getName());
        lapTimesDriverRaceDTO.setYear(raceData.getYear());
        lapTimesDriverRaceDTO.setLapTimes(this.lapTimesRepository.findLapTimerDriverRace(driverId, raceId));

        this.lapTimesDriverRaceRequestEvent.sendMessage(lapTimesDriverRaceDTO);
        return lapTimesDriverRaceDTO;
    }
}
