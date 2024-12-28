package com.f1api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LatAccDTO implements Serializable{

    private UUID id;

    @Field("carMotionData.gForceLateral")
    private List<String> accLat;

    @Field("packetHeaderEntity.sessionTime")
    private String sessionTime;
}
