package com.f1api.entity;

import java.util.Date;

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
    private Integer driverId;

    @Column(name = "driver_ref")
    private String driverRef;

    @Column(name = "number")
    private Double number;

    @Column(name = "code")
    private String code;

    @Column(name = "forename")
    private String forename;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "url")
    private String url;

}

