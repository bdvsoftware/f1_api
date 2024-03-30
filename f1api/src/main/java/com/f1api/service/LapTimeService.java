package com.f1api.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.f1api.dto.LapTimesDriverRaceDTO;
import com.f1api.kafka.producer.laptime.LapTimesDriverRaceRequestEvent;
import com.f1api.repository.DriverRepository;
import com.f1api.repository.LapTimesRepository;
import com.f1api.repository.RaceRepository;
import com.f1api.repository.mongo.LapTimeDriverMongoRepository;
import com.f1api.entity.Driver;
import com.f1api.entity.Race;
import com.f1api.entity.mongo.LapTimeDriverMongo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LapTimeService {
    
    private final LapTimesRepository lapTimesRepository;

    private final DriverRepository driverRepository;

    private final RaceRepository raceRepository;

    private final LapTimesDriverRaceRequestEvent lapTimesDriverRaceRequestEvent;

    private final LapTimeDriverMongoRepository lapTimeDriverMongoRepository;

    private final Base64Service base64Service;

    private static final String GRAPHIC_SERVICE_URL = "http://localhost:5000/generate-graphic";

    @Transactional
    public List<LapTimesDriverRaceDTO> getLapTimesDriverRace(Short[] driverIds, Long raceId){
        List<LapTimesDriverRaceDTO> lapTimesDriverRaceDTOs = new ArrayList<>();

        Race raceData = this.raceRepository.findById(raceId).get();

        for(Short driverId : driverIds){
            LapTimesDriverRaceDTO lapTimesDriverRaceDTO = new LapTimesDriverRaceDTO();
            Driver driverData = this.driverRepository.findById(driverId).get();
            lapTimesDriverRaceDTO.setDriverId(driverId);
            lapTimesDriverRaceDTO.setDriverName(driverData.getForename()+" "+driverData.getSurname());

            lapTimesDriverRaceDTO.setRaceId(raceId);
            lapTimesDriverRaceDTO.setGp(raceData.getName());
            lapTimesDriverRaceDTO.setYear(raceData.getYear());
            lapTimesDriverRaceDTO.setLapTimes(this.lapTimesRepository.findLapTimerDriverRace(driverId, raceId));

            lapTimesDriverRaceDTOs.add(lapTimesDriverRaceDTO);
        }

        WebClient webClient = WebClient.create();

        String img = webClient.post()
                .uri(GRAPHIC_SERVICE_URL)
                .body(BodyInserters.fromValue(lapTimesDriverRaceDTOs))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        this.base64Service.decodeAndSaveImage(img, raceData.getName(), raceData.getYear());

        this.lapTimesDriverRaceRequestEvent.sendMessage(lapTimesDriverRaceDTOs);

        this.lapTimeDriverMongoRepository.sa

        return lapTimesDriverRaceDTOs;
    }

    private List<LapTimeDriverMongo> toMongo

}
