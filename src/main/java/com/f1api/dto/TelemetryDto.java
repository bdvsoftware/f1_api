package com.f1api.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TelemetryDto<T> {
    
    private UUID headerId;

    private String yAxisName;

    private T yAxisValue;
    
    private BigDecimal xAxisValue;

    private String stintName;
}
