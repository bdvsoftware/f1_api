package com.f1api.service.packet;

import org.springframework.stereotype.Service;

import com.f1api.entity.mongo.packet.PacketHeaderEntity;
import com.f1api.kafka.messaging.packet.types.PacketHeader;

@Service
public class BaseService {
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
}
