package com.f1api.service.packet;


import org.springframework.stereotype.Service;
import com.f1api.entity.mongo.packet.lapdata.PacketLapDataEntity;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketLapData;
import com.f1api.repository.mongo.packet.PacketLapDataMongoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.f1api.entity.mongo.packet.lapdata.LapDataEntity;
import com.f1api.kafka.messaging.data.LapData;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacketLapDataService extends BaseService{

    private final PacketLapDataMongoRepository repository;

    public void process(PacketReceived packet){
       this.repository.save(this.createEntity(packet));
    }

    private PacketLapDataEntity createEntity(PacketReceived packet){
        var lapDataPacket = (PacketLapData) packet.getData();
        PacketLapDataEntity entity = new PacketLapDataEntity(
            UUID.randomUUID(), 
            this.createHeaderEntity(lapDataPacket.getPacketHeader()), 
            this.createLapDataEntityList(lapDataPacket.getLapData()), 
            lapDataPacket.getTimeTrialPBCarIdx(), 
            lapDataPacket.getTimeTrialRivalCarIdx(), 
            LocalDateTime.now());
        return entity;
    }

    private List<LapDataEntity> createLapDataEntityList(List<LapData> list){
        return list.stream()
        .map(item -> new LapDataEntity( 
            item.getLastLapTimeInMS(),
            item.getCurrentLapTimeInMS(),
            item.getSector1TimeInMS(),
            item.getSector1TimeMinutes(),
            item.getSector2TimeInMS(),
            item.getSector2TimeMinutes(),
            item.getDeltaToCarInFrontInMS(),
            item.getDeltaToRaceLeaderInMS(),
            item.getLapDistance(),
            item.getTotalDistance(),
            item.getSafetyCarDelta(),
            item.getCarPosition(),
            item.getCurrentLapNum(),
            item.getPitStatus(),
            item.getNumPitStops(),
            item.getSector(),
            item.getCurrentLapInvalid(),
            item.getPenalties(),
            item.getTotalWarnings(),
            item.getCornerCuttingWarnings(),
            item.getNumUnservedDriveThroughPens(),
            item.getNumUnservedStopGoPens(),
            item.getGridPosition(), 
            item.getDriverStatus(),
            item.getResultStatus(),
            item.getPitLaneTimerActive()
        ))
        .collect(Collectors.toList());
    }
}
