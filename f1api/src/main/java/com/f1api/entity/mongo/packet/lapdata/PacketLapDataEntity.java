package com.f1api.entity.mongo.packet.lapdata;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;
import com.f1api.entity.mongo.packet.PacketHeaderEntity;
import jakarta.persistence.Id;

@Document("packet_lap_data")
public record PacketLapDataEntity (
    @Id UUID id,
    PacketHeaderEntity packetHeaderEntity,
    List<LapDataEntity> lapData,
    BigInteger timeTrialPBCarIdx,
    BigInteger timeTrialRivalCarIdx,
    LocalDateTime createdAt
){}
