package com.senai.inmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.inmind.entities.Psychologist;

@Repository
public interface PsychologistRepository extends JpaRepository<Psychologist, Long>{
    
}
