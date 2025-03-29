package com.f1api.service.packet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.carstatus.CarStatusDataEntity;
import com.f1api.entity.mongo.packet.carstatus.PacketCarStatusDataEntity;
import com.f1api.kafka.messaging.data.CarStatusData;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketCarStatus;
import com.f1api.repository.mongo.packet.PacketCarStatusDataMongoRepository;
import com.f1api.repository.mongo.stint.StintMongoRepository;

@Service
public class PacketCarStatusDataService extends BaseService {

    private final PacketCarStatusDataMongoRepository repository;

    public PacketCarStatusDataService(
            PacketCarStatusDataMongoRepository repository,
            StintMongoRepository stintMongoRepository) {
        super(stintMongoRepository);
        this.repository = repository;
    }

    public void process(PacketReceived packet) {
        this.saveStintNameIfNotExists(packet.getStintName());
        this.repository.save(this.createEntity(packet));
    }

    private PacketCarStatusDataEntity createEntity(PacketReceived packet) {
        var carStatusData = (PacketCarStatus) packet.getData();
        PacketCarStatusDataEntity entity = new PacketCarStatusDataEntity(
                UUID.randomUUID(),
                packet.getStintName(),
                this.createHeaderEntity(carStatusData.getPacketHeader()),
                this.createCarStatusDataEntityList(carStatusData.getCarStatusData()),
                LocalDateTime.now());
        return entity;
    }

    private List<CarStatusDataEntity> createCarStatusDataEntityList(List<CarStatusData> list) {
        return list
                .stream()
                .map(item -> new CarStatusDataEntity(
                        item.getTractionControl(),
                        item.getAntiLockBrakes(),
                        item.getFuelMix(),
                        item.getFrontBrakeBias(),
                        item.getPitLimiterStatus(),
                        item.getFuelInTank(),
                        item.getFuelCapacity(),
                        item.getFuelRemainingLaps(),
                        item.getMaxRPM(),
                        item.getIdleRPM(),
                        item.getMaxGears(),
                        item.getDrsAllowed(),
                        item.getDrsActivationDistance(),
                        item.getActualTyreCompound(),
                        item.getVisualTyreCompound(),
                        item.getTyresAgeLaps(),
                        item.getVehicleFiaFlags(),
                        item.getEnginePowerICE(),
                        item.getEnginePowerMGUK(),
                        item.getErsStoreEnergy(),
                        item.getErsDeployMode(),
                        item.getErsHarvestedThisLapMGUK(),
                        item.getErsHarvestedThisLapMGUH(),
                        item.getErsDeployedThisLap(),
                        item.getNetworkPaused()))
                .collect(Collectors.toList());
    }
}
