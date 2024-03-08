package com.f1api.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.f1api.dto.GraphicDTO;
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

    private final Base64Service base64Service;

    private static final String GRAPHIC_SERVICE_URL = "http://localhost:5000/generate-graphic";

    @Transactional
    public String getLapTimesDriverRace(Short driverId, Long raceId){
        LapTimesDriverRaceDTO lapTimesDriverRaceDTO = new LapTimesDriverRaceDTO();
        Driver driverData = this.driverRepository.findById(driverId).get();
        lapTimesDriverRaceDTO.setDriverId(driverId);
        lapTimesDriverRaceDTO.setDriverName(driverData.getForename()+" "+driverData.getSurname());
        
        Race raceData = this.raceRepository.findById(raceId).get();
        lapTimesDriverRaceDTO.setRaceId(raceId);
        lapTimesDriverRaceDTO.setGp(raceData.getName());
        lapTimesDriverRaceDTO.setYear(raceData.getYear());
        lapTimesDriverRaceDTO.setLapTimes(this.lapTimesRepository.findLapTimerDriverRace(driverId, raceId));

        WebClient webClient = WebClient.create();

        String img = webClient.post()
                .uri(GRAPHIC_SERVICE_URL)
                .body(BodyInserters.fromValue(lapTimesDriverRaceDTO))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        this.base64Service.decodeAndSaveImage(img, driverData.getForename()+driverData.getSurname(), raceData.getName(), raceData.getYear());

        this.lapTimesDriverRaceRequestEvent.sendMessage(lapTimesDriverRaceDTO);
        return img;
    }

}
