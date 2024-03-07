package com.f1api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "circuits")
@Data
public class Circuit {
    
    @Id
    @Column(name = "circuit_id")
    private Long id;
    
    @Column(name = "circuit_ref")
    private String circuitRef;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "alt")
    private Double alt;

    @Column(name = "url")
    private String url;
}
