package com.f1api.kafka.messaging.packet;

import java.io.Serializable;
import java.util.List;

import com.f1api.kafka.messaging.data.LapData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PacketLapData implements Serializable{

    private PacketHeader packetHeader;
    private List<LapData> lapDataList;
}
