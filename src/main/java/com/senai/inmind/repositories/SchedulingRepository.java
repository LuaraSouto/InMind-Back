package com.senai.inmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.inmind.entities.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{
    
}
