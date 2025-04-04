package com.f1api.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TelemetryDto<T> {

    @JsonProperty("headerId")
    private UUID headerId;

    @JsonProperty("yAxisName")
    private String yAxisName;

    @JsonProperty("yAxisValue")
    private T yAxisValue;

    @JsonProperty("xAxisValue")
    private BigDecimal xAxisValue;

    @JsonProperty("stintName")
    private String stintName;
}
