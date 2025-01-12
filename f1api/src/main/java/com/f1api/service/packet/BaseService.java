package com.f1api.service.packet;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;
import com.f1api.entity.mongo.stint.StintEntity;
import com.f1api.kafka.messaging.packet.types.PacketHeader;
import com.f1api.repository.mongo.stint.StintMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BaseService {

    protected final StintMongoRepository stintRepository;

    protected PacketHeaderEntity createHeaderEntity(PacketHeader packetHeader){
        return new PacketHeaderEntity(
            packetHeader.getPacketFormat(),
            packetHeader.getGameYear(),
            packetHeader.getGameMajorVersion(),
            packetHeader.getGameMinorVersion(),
            packetHeader.getPacketVersion(),
            packetHeader.getPacketId(),
            packetHeader.getSessionUID(),
            packetHeader.getSessionTime(),
            packetHeader.getFrameIdentifier(),
            packetHeader.getOverallFrameIdentifier(),
            packetHeader.getPlayerCarIndex(),
            packetHeader.getSecondaryPlayerCarIndex()
        );
    }

    protected void saveStintNameIfNotExists(String stintName){
        if(!this.stintRepository.existsByStintName(stintName)){
            this.stintRepository.save(new StintEntity(UUID.randomUUID(), stintName, LocalDateTime.now()));
        }
    }
}
