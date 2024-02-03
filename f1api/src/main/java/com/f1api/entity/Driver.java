package com.f1api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "drivers")
@Data
public class Driver {
    
    @Id
    @Column(name = "driver_id")
    private Short driverId;

}
