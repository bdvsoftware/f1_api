package com.f1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.f1api.dto.LapTimeDTO;
import com.f1api.entity.LapTime;

public interface LapTimesRepository extends JpaRepository<LapTime, Long>{
    @Query("select new com.f1api.dto.LapTimeDTO("
        +" lt.lapTimeId, lt.lap, lt.position, lt.time, lt.milliseconds)"
        +" from LapTime lt"
        +" inner join lt.race r"
        +" inner join lt.driver d"
        +" where r.raceId = :raceId and d.driverId in (:driverId)"
    )
    public List<LapTimeDTO> findLapTimerDriverRace(@Param("driverId") Short driverId, @Param("raceId") Long raceId);
}
