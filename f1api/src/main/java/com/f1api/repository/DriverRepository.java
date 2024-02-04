package com.f1api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1api.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Short>{

    
}
