package com.f1api.service.packet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.cartelemetry.CarTelemetryDataEntity;
import com.f1api.entity.mongo.packet.cartelemetry.PacketCarTelemetryDataEntity;
import com.f1api.kafka.messaging.data.CarTelemetryData;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketCarTelemetry;
import com.f1api.repository.mongo.packet.PacketCarTelemetryDataMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacketCarTelemetryDataService extends BaseService{
    
    private final PacketCarTelemetryDataMongoRepository repository;

    public void process(PacketReceived packet){
        this.repository.save(this.createEntity(packet));
    }

    private PacketCarTelemetryDataEntity createEntity(PacketReceived packet){
        var carTelemetryData = (PacketCarTelemetry) packet.getData();
        PacketCarTelemetryDataEntity entity = new PacketCarTelemetryDataEntity(
            UUID.randomUUID(), 
            packet.getStintName(),
            this.createHeaderEntity(carTelemetryData.getPacketHeader()), 
            this.createCarTelemetryDataEntityList(carTelemetryData.getCarTelemetryData()), 
            carTelemetryData.getMfdPanelIndex(),
            carTelemetryData.getMfdPanelIndexSecondaryPlayer(),
            carTelemetryData.getSuggestedGear(),
            LocalDateTime.now());
        return entity;
    }

    private List<CarTelemetryDataEntity> createCarTelemetryDataEntityList(List<CarTelemetryData> list){
        return list.stream()
        .map(item -> new CarTelemetryDataEntity(
            item.getSpeed(),
            item.getThrottle(),
            item.getSteer(),
            item.getBrake(),
            item.getClutch(),
            item.getGear(),
            item.getEngineRPM(),
            item.getDrs(),
            item.getRevLightsPercent(),
            item.getRevLightsBitValue(),
            item.getBrakesTemperature(),
            item.getTyresSurfaceTemperature(),
            item.getTyresInnerTemperature(),
            item.getEngineTemperature(),
            item.getTyresPressure(),
            item.getSurfaceType()
        ))
        .collect(Collectors.toList());
    }
}
