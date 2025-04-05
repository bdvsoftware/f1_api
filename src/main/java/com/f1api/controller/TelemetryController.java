package com.f1api.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.f1api.dto.MultipleYAxisRequestDto;
import org.springframework.web.bind.annotation.*;

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
    public Set<YAxisDto> getYAxisOptions(){
        return this.telemetryService.getYAxisAtributes();
    }

    @PostMapping("/stint-data")
    public <T> Map<String, List<TelemetryDto>> getTelemetryData(
            @RequestBody MultipleYAxisRequestDto body,
            @RequestParam String xAxis,
            @RequestParam String stint){
        return this.telemetryService.findTelemetryData(body, xAxis, stint);
    }
}
