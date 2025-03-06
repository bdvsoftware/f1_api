package com.f1api.service.packet;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.f1api.kafka.messaging.packet.PacketReceived;
import com.f1api.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacketService {

    private final PacketLapDataService packetLapDataService;

    private final PacketCarTelemetryDataService packetCarTelemetryDataService;

    private final PacketMotionDataService packetMotionDataService;

    private final PacketMotionExDataService packetMotionExDataService;

    private final PacketCarSetupDataService packetCarSetupDataService;

    private final PacketCarStatusDataService packetCarStatusDataService;

    private final HashMap<Short, Consumer<PacketReceived>> functionMap;

    public PacketService(
        PacketLapDataService packetLapDataService,
        PacketCarTelemetryDataService packetCarTelemetryDataService,
        PacketMotionDataService packetMotionDataService,
        PacketMotionExDataService packetMotionExDataService,
        PacketCarSetupDataService packetCarSetupDataService,
        PacketCarStatusDataService packetCarStatusDataService
    ) {
        this.packetLapDataService = packetLapDataService;
        this.packetCarTelemetryDataService = packetCarTelemetryDataService;
        this.packetMotionDataService = packetMotionDataService;
        this.packetMotionExDataService = packetMotionExDataService;
        this.packetCarSetupDataService = packetCarSetupDataService;
        this.packetCarStatusDataService = packetCarStatusDataService;
        this.functionMap = new HashMap<>();
        this.functionMap.put(Constants.PacketId.LAP_DATA_PACKET, packetLapDataService::process);
        this.functionMap.put(Constants.PacketId.MOTION_PACKET, packetMotionDataService::process);
        this.functionMap.put(Constants.PacketId.CAR_TELEMETRY_PACKET, packetCarTelemetryDataService::process);
        this.functionMap.put(Constants.PacketId.MOTION_EX_PACKET, packetMotionExDataService::process);
        this.functionMap.put(Constants.PacketId.CAR_SETUP_PACKET, packetCarSetupDataService::process);
        this.functionMap.put(Constants.PacketId.CAR_STATUS_PACKET, packetCarStatusDataService::process);
    }

    public void process(PacketReceived packet){
        log.debug("Processing packet with id: " + packet.getId());
        var action = this.functionMap.get(packet.getId());
        if(Objects.nonNull(action)){
            action.accept(packet);
        }
    }
    
}
