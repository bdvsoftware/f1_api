package com.f1api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MultipleYAxisRequestDto implements Serializable {

    @JsonProperty("yAxis")
    private List<YAxisRequestDto> yAxis;
}
