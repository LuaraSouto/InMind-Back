package com.senai.inmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.inmind.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    
}
