package com.f1api.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "races")
@Getter
@Setter
public class Race {

    @Id
    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "round")
    private Integer round;

    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    @Column(name = "url")
    private String url;

    @Column(name = "fp1_date")
    private Date fp1Date;

    @Column(name = "fp1_time")
    private String fp1Time;

    @Column(name = "fp2_date")
    private Date fp2Date;

    @Column(name = "fp2_time")
    private String fp2Time;

    @Column(name = "fp3_date")
    private Date fp3Date;

    @Column(name = "fp3_time")
    private String fp3Time;

    @Column(name = "quali_date")
    private Date qualiDate;

    @Column(name = "quali_time")
    private String qualiTime;

    @Column(name = "sprint_date")
    private Date sprintDate;

    @Column(name = "sprint_time")
    private String sprintTime;

}
