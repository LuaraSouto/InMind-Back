package com.senai.inmind.entities;

import java.time.LocalDateTime;

import com.senai.inmind.dtos.SchedulingInputDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scheduling {
  public Scheduling(SchedulingInputDTO dto) {
    this.appointmentTime = dto.getAppointmentTime();
    this.platform = dto.getPlatform();
    this.psychologist = new Psychologist();
    this.psychologist.setId(dto.getPsychologist());
    this.patient = new Patient();
    this.patient.setId(dto.getPatient());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private LocalDateTime appointmentTime;
  private String platform;
  @ManyToOne(optional = true)
  private Psychologist psychologist;
  @ManyToOne(optional = true)
  private Patient patient;




}

