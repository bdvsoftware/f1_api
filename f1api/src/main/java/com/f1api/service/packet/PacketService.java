package com.f1api.service.packet;

import java.util.HashMap;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.util.Constants;

@Service
public class PacketService {

    private final PacketLapDataService packetLapDataService;

    private final PacketCarTelemetryDataService packetCarTelemetryDataService;

    private final HashMap<Short, Consumer<PacketReceived>> functionMap;

    public PacketService(
        PacketLapDataService packetLapDataService,
        PacketCarTelemetryDataService packetCarTelemetryDataService
    ) {
        this.packetLapDataService = packetLapDataService;
        this.packetCarTelemetryDataService = packetCarTelemetryDataService;
        this.functionMap = new HashMap<>();
        this.functionMap.put(Constants.PacketId.LAP_DATA_PACKET, packetLapDataService::process);
        this.functionMap.put(Constants.PacketId.CAR_TELEMETRY_PACKET, packetCarTelemetryDataService::process);
    }

    public void process(PacketReceived packet){
        var action = this.functionMap.get(packet.getId());
        if(action != null){
            action.accept(packet);
        }
    }
    
}
