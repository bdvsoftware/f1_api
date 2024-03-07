package com.f1api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RaceDTO {
    
    public String name;

    public Integer year;
}
