package com.f1api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.f1api.dto.RaceDTO;

import com.f1api.entity.Race;

public interface RaceRepository extends JpaRepository<Race,Long> {
    @Query("select new com.f1api.dto.RaceDTO(r.name, r.year) from Race r where r.id = :raceId")
    public RaceDTO getRaceById(Short raceId);
}
