package com.f1api.service.packet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;
import com.f1api.entity.mongo.packet.lapdata.LapDataEntity;
import com.f1api.entity.mongo.packet.lapdata.PacketLapDataEntity;
import com.f1api.kafka.messaging.packet.types.PacketLapData;
import com.f1api.repository.mongo.packet.PacketLapDataMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacketLapDataEventService {

    private final PacketLapDataMongoRepository repository;

    /*public void process(PacketLapData data){
        var packetHeaderEntity = createPacketHeaderEntity(data);

        var lapTimesEntities = createPacketLapDataEntity(data);

        var packetLapDataEntity = new PacketLapDataEntity(
            UUID.randomUUID(),
            packetHeaderEntity,
            lapTimesEntities,
            data.getM_timeTrialPBCarIdx(),
            data.getM_timeTrialRivalCarIdx(),
            LocalDateTime.now()
        );

        repository.save(packetLapDataEntity);
    }

    private PacketHeaderEntity createPacketHeaderEntity(PacketLapData data){
        return new PacketHeaderEntity(
            data.getM_header().getM_packetFormat(),
            data.getM_header().getM_gameYear(),
            data.getM_header().getM_gameMajorVersion(),
            data.getM_header().getM_gameMinorVersion(),
            data.getM_header().getM_packetVersion(),
            data.getM_header().getM_packetId(),
            data.getM_header().getM_sessionUID(),
            data.getM_header().getM_sessionTime(),
            data.getM_header().getM_frameIdentifier(),
            data.getM_header().getM_overallFrameIdentifier(),
            data.getM_header().getM_playerCarIndex(),
            data.getM_header().getM_secondaryPlayerCarIndex()
            );
    }

    private List<LapDataEntity> createPacketLapDataEntity(PacketLapData data){
        return data.getM_lapData().stream()
        .map(lapData -> new LapDataEntity(
                lapData.getM_lastLapTimeInMS(),
                lapData.getM_currentLapTimeInMS(),
                lapData.getM_sector1TimeInMS(),
                lapData.getM_sector1TimeMinutes(),
                lapData.getM_sector2TimeInMS(),
                lapData.getM_sector2TimeMinutes(),
                lapData.getM_deltaToCarInFrontInMS(),
                lapData.getM_deltaToRaceLeaderInMS(),
                lapData.getM_lapDistance(),
                lapData.getM_totalDistance(),
                lapData.getM_safetyCarDelta(),
                lapData.getM_carPosition(),
                lapData.getM_currentLapNum(),
                lapData.getM_pitStatus(),
                lapData.getM_numPitStops(),
                lapData.getM_sector(),
                lapData.getM_currentLapInvalid(),
                lapData.getM_penalties(),
                lapData.getM_totalWarnings(),
                lapData.getM_cornerCuttingWarnings(),
                lapData.getM_numUnservedDriveThroughPens(),
                lapData.getM_numUnservedStopGoPens(),
                lapData.getM_gridPosition(),
                lapData.getM_driverStatus(),
                lapData.getM_resultStatus(),
                lapData.getM_pitLaneTimerActive(),
                lapData.getM_pitLaneTimeInLaneInMS() != null ?
                    lapData.getM_pitLaneTimeInLaneInMS() :
                    null,
                lapData.getM_pitStopTimerInMS() != null ?
                    lapData.getM_pitStopTimerInMS() :
                    null,
                lapData.getM_pitStopShouldServePen() != null ?
                    lapData.getM_pitStopShouldServePen() :
                    null
        )).toList();
    }*/
}
