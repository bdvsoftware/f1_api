package com.f1api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class YAxisRequestDto implements Serializable {
    private String name;
    private String refEntity;
}
