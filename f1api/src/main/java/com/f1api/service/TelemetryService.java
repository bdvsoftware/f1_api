package com.f1api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.f1api.dto.LatAccDTO;
import com.f1api.dto.TelemetryDto;
import com.f1api.dto.YAxisDto;
import com.f1api.entity.mongo.packet.cartelemetry.PacketCarTelemetryDataEntity;
import com.f1api.entity.mongo.packet.lapdata.LapDataEntity;
import com.f1api.entity.mongo.packet.lapdata.PacketLapDataEntity;
import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import com.f1api.entity.mongo.packet.motionex.PacketMotionExDataEntity;
import com.f1api.repository.mongo.packet.PacketCarTelemetryDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketLapDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketMotionDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketMotionExDataMongoRepository;
import com.f1api.util.Constants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelemetryService {
    
    private final PacketCarTelemetryDataMongoRepository carTelemetryDataRepository;

    private final PacketLapDataMongoRepository lapDataRepository;

    private final PacketMotionDataMongoRepository motionDataRepository;

    private final PacketMotionExDataMongoRepository motionExDataRepository;

    private final Base64Service base64Service;

    private final WebClient webClient = WebClient.create();
    
    public List<LatAccDTO> produceLatAccGraph(String stint){
        var entities = this.motionDataRepository.findAllLatAccByStintName(stint);
        var dtos = entities.stream()
        .map(item -> new LatAccDTO(item.id(), item.carMotionData().get(0).gForceLateral(), item.packetHeaderEntity().sessionTime(), item.stintName()))
        .collect(Collectors.toList());

        String img = webClient.post()
                .uri(Constants.Url.GENERATE_LAT_ACC_TIMES_GRAPHIC)
                .body(BodyInserters.fromValue(dtos))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        this.base64Service.decodeAndSaveImage(img, dtos.get(0).getStint());

        return dtos;
    }

    public List<YAxisDto> getYAxisAtributes(){
        List<Class> classes = List.of(
            PacketCarTelemetryDataEntity.class, 
            PacketLapDataEntity.class, 
            PacketMotionDataEntity.class, 
            PacketMotionExDataEntity.class);
        return this.getClassAtributes(classes);
    }

    private List<YAxisDto> getClassAtributes(List<Class> classList){
        ArrayList<YAxisDto> yAxisFields = new ArrayList<>();
        classList.forEach(c -> {
            List.of(c.getDeclaredFields())
                .stream()
                .filter(field -> !field.getName().equals(Constants.PACKET_HEADER_ENTITY_STRING))
                .forEach(item -> {
                    if(Constants.SubEntities.NAME_LIST.contains(item.getName())){
                        List.of(item.getClass().getDeclaredFields())
                        .stream()
                        .filter(field -> !field.getName().equals(Constants.PACKET_HEADER_ENTITY_STRING))
                        .forEach(subItem -> {
                            yAxisFields.add(new YAxisDto(subItem.getName(), c.getSimpleName()));
                        });
                    }else{
                        yAxisFields.add(new YAxisDto(item.getName(), c.getSimpleName()));
                    }
            });
        });
        return yAxisFields;
    }

    public List<TelemetryDto> findTelemetryData(
        String yAxis,
        String refEntity, 
        String xAxis,
        String stint){
            return this.findLapData(yAxis, refEntity, xAxis, stint);
    }

    private <T> List<TelemetryDto> findLapData(String yAxis,
        String refEntity, 
        String xAxis,
        String stint){
            List<TelemetryDto> data = new ArrayList<>();
            var rawData = this.lapDataRepository.findByStintName(stint);
            rawData.forEach(item -> {
                var id = item.id();
                var currentPlayerData = item.lapData().getFirst();
                try{
                    var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                    yAtribute.setAccessible(Boolean.TRUE);
                    T yValue = (T) yAtribute.get(currentPlayerData);
                    data.add(new TelemetryDto<T>(item.id(), yValue, item.packetHeaderEntity().sessionTime(), stint));
                }catch(Exception e) {
                    log.error("Error retrieving atribute: ", yAxis, e);
                }
            });
            
            return data;
    }
}
