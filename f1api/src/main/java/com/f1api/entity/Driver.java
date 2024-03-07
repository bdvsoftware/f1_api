package com.f1api.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drivers")
@Getter
@Setter
public class Driver {

    @Id
    @Column(name = "driver_id")
    private Short driverId;

    @Column(name = "driver_ref")
    private String driverRef;

    @Column(name = "number")
    private Short number;

    @Column(name = "code")
    private String code;

    @Column(name = "forename")
    private String forename;

    @Column(name = "surname")
    private String surname;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", columnDefinition = "DATE")
    private Date dob;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "url")
    private String url;

}

