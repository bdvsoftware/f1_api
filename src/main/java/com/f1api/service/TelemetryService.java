package com.f1api.service;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.f1api.dto.MultipleYAxisRequestDto;
import com.f1api.repository.mongo.packet.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.f1api.dto.LatAccDTO;
import com.f1api.dto.TelemetryDto;
import com.f1api.dto.YAxisDto;
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

    private final PacketCarStatusDataMongoRepository carStatusDataRepository;

    private final PacketCarSetupDataMongoRepository carSetupDataRepository;

    private final Base64Service base64Service;

    private final WebClient webClient = WebClient.create();

    private final Map<String, BiFunction<String, String, List<TelemetryDto>>> stintDataFinders = Map.of(
            Constants.CAR_MOTION_ENTITY_STRING, this::findStintCarMotionData,
            Constants.CAR_MOTION_EX_ENTITY_STRING, this::findStintCarMotionExData,
            Constants.CAR_TELEMETRY_ENTITY_STRING, this::findStintCarTelemetryData,
            Constants.LAP_DATA_ENTITY_STRING, this::findStintLapData,
            Constants.CAR_STATUS_ENTITY_STRING, this::findStintCarStatusData,
            Constants.CAR_SETUP_ENTITY_STRING, this::findStintCarSetupData
    );

    public List<LatAccDTO> produceLatAccGraph(String stint) {
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

    public Set<YAxisDto> getYAxisAtributes() {
        Set<YAxisDto> yAxisFields = new HashSet<>();

        Constants.Entities.NAME_LIST.forEach(c -> {
            Arrays.stream(c.getDeclaredFields())
                    .filter(field -> !field.getName().equals(Constants.PACKET_HEADER_ENTITY_STRING) &&
                            !Constants.EXCLUDED_FIELDS.contains(field.getName()))
                    .forEach(item -> {
                        yAxisFields.add(new YAxisDto(item.getName(), c.getSimpleName()));
                    });
        });

        return yAxisFields.stream()
                .sorted(Comparator.comparing(YAxisDto::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<String, List<TelemetryDto>> findTelemetryData(
            MultipleYAxisRequestDto requestDto,
            String xAxis,
            String stint) {
        Map<String, List<TelemetryDto>> data = new HashMap<>();
        requestDto.getYAxis().forEach(y -> {
            data.put(y.getName(), this.findStintData(y.getName(), y.getRefEntity(), stint));
        });
        return data;
    }

    private <T> List<TelemetryDto> findStintData(String yAxis,
                                                 String refEntity,
                                                 String stint) {
        return stintDataFinders.getOrDefault(refEntity, (s, y) -> new ArrayList<>()).apply(stint, yAxis);
    }

    private <T> ArrayList<TelemetryDto> findStintLapData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.lapDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            var currentPlayerData = item.lapData().getFirst();
            try {
                var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(currentPlayerData);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }

    private <T> ArrayList<TelemetryDto> findStintCarTelemetryData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.carTelemetryDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            var currentPlayerData = item.carTelemetryData().getFirst();
            try {
                var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(currentPlayerData);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }

    private <T> ArrayList<TelemetryDto> findStintCarMotionExData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.motionExDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            try {
                var yAtribute = item.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(item);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }

    private <T> ArrayList<TelemetryDto> findStintCarMotionData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.motionDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            var currentPlayerData = item.carMotionData().getFirst();
            try {
                var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(currentPlayerData);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }

    private <T> ArrayList<TelemetryDto> findStintCarSetupData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.carSetupDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            var currentPlayerData = item.carSetups().getFirst();
            try {
                var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(currentPlayerData);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }

    private <T> ArrayList<TelemetryDto> findStintCarStatusData(String stint, String yAxis) {
        var data = new ArrayList<TelemetryDto>();
        var rawData = this.carStatusDataRepository.findByStintName(stint);
        rawData.forEach(item -> {
            var currentPlayerData = item.carStatusData().getFirst();
            try {
                var yAtribute = currentPlayerData.getClass().getDeclaredField(yAxis);
                yAtribute.setAccessible(Boolean.TRUE);
                T yValue = (T) yAtribute.get(currentPlayerData);
                data.add(new TelemetryDto<T>(item.id(), yAxis, yValue, item.packetHeaderEntity().sessionTime(), stint));
            } catch (Exception e) {
                log.error("Error retrieving atribute: ", yAxis, e);
            }
        });
        return data;
    }
}
