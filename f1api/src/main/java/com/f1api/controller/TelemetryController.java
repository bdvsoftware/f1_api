package com.f1api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f1api.dto.LatAccDTO;
import com.f1api.dto.TelemetryDto;
import com.f1api.dto.YAxisDto;
import com.f1api.service.TelemetryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/telemetry")
@RequiredArgsConstructor
public class TelemetryController {
    
    private final TelemetryService telemetryService;

    @GetMapping("/lateral-acc")
    public List<LatAccDTO> getLatAccGraph(@RequestParam String stint){
        return this.telemetryService.produceLatAccGraph(stint);
    }

    @GetMapping("/y-axis-options")
    public List<YAxisDto> getYAxisOptions(){
        return this.telemetryService.getYAxisAtributes();
    }

    @GetMapping("/stint-data")
    public List<TelemetryDto> getTelemetryData(
        @RequestParam String yAxis,
        @RequestParam String refEntity,
        @RequestParam String xAxis,
        @RequestParam String stint){
        return this.telemetryService.findTelemetryData(yAxis, refEntity, xAxis, stint);
    }
}
