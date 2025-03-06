package com.f1api.service.packet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.carsetup.CarSetupDataEntity;
import com.f1api.entity.mongo.packet.carsetup.PacketCarSetupDataEntity;
import com.f1api.kafka.messaging.data.CarSetupData;
import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.kafka.messaging.packet.types.PacketCarSetup;
import com.f1api.repository.mongo.packet.PacketCarSetupDataMongoRepository;
import com.f1api.repository.mongo.stint.StintMongoRepository;

@Service
public class PacketCarSetupDataService extends BaseService {
    
    private final PacketCarSetupDataMongoRepository repository;

    public PacketCarSetupDataService (
        StintMongoRepository stintMongoRepository,
        PacketCarSetupDataMongoRepository repository
    ) {
        super(stintMongoRepository);
        this.repository = repository;
    }

    public void process(PacketReceived packet) {
        this.saveStintNameIfNotExists(packet.getStintName());
        this.repository.save(this.createPacketCarSetupDataEntity(packet));
    }

    private PacketCarSetupDataEntity createPacketCarSetupDataEntity(PacketReceived packet) {
        var carSetupData = (PacketCarSetup) packet.getData();
        PacketCarSetupDataEntity entity = new PacketCarSetupDataEntity(
            UUID.randomUUID(), 
            packet.getStintName(), 
            this.createHeaderEntity(carSetupData.getPacketHeader()), 
            this.createCarSetupDataEntityList(carSetupData.getCarSetups()), 
            LocalDateTime.now());
        return entity;
    }

    private List<CarSetupDataEntity> createCarSetupDataEntityList(List<CarSetupData> list) {
        return list
            .stream()
            .map(item -> new CarSetupDataEntity(
                item.getFrontWing(),
                item.getRearWing(),
                item.getOffThrottle(),
                item.getOffThrottle(),
                item.getFrontCamber(),
                item.getRearCamber(),
                item.getFrontToe(),
                item.getRearToe(),
                item.getFrontSuspension(),
                item.getFrontSuspension(),
                item.getFrontAntiRollBar(),
                item.getFrontAntiRollBar(),
                item.getFrontSuspensionHeight(),
                item.getFrontSuspensionHeight(),
                item.getBrakePressure(),
                item.getBrakeBias(),
                item.getFrontLeftTyrePressure(),
                item.getFrontRightTyrePressure(),
                item.getFrontLeftTyrePressure(),
                item.getFrontRightTyrePressure(),
                item.getBallast(),
                item.getFuelLoad()
            ))
            .collect(Collectors.toList());
    }
}
