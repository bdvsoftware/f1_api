package com.f1api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.f1api.dto.LatAccDTO;
import com.f1api.entity.mongo.packet.motion.PacketMotionDataEntity;
import com.f1api.service.TelemetryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("api/telemetry")
@RequiredArgsConstructor
public class TelemetryController {
    
    private final TelemetryService telemetryService;

    @GetMapping("/lateral-acc")
    public List<LatAccDTO> getLatAccGraph(@RequestParam String stint){
        return this.telemetryService.produceLatAccGraph(stint);
    }
}
