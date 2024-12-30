package com.f1api.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.f1api.dto.LatAccDTO;
import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import com.f1api.repository.mongo.packet.PacketCarTelemetryDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketLapDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketMotionDataMongoRepository;
import com.f1api.repository.mongo.packet.PacketMotionExDataMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TelemetryService {
    
    private final PacketCarTelemetryDataMongoRepository carTelemetryDataRepository;

    private final PacketLapDataMongoRepository lapDataRepository;

    private final PacketMotionDataMongoRepository motionDataRepository;

    private final PacketMotionExDataMongoRepository motionExDataRepository;

    public List<LatAccDTO> produceLatAccGraph(String stint){
        var entities = this.motionDataRepository.findAllLatAccByStintName(stint);
        var dtos = entities.stream()
        .map(item -> new LatAccDTO(item.id(), item.carMotionData().get(0).gForceLateral(), item.packetHeaderEntity().sessionTime()))
        .collect(Collectors.toList());
        return dtos;
    }
}
