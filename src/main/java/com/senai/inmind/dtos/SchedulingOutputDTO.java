package com.senai.inmind.dtos;

import java.time.LocalDateTime;

import com.senai.inmind.entities.Patient;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.entities.Scheduling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SchedulingOutputDTO {
  private Long id;
  private LocalDateTime appointmentTime;
  private String platform;
  private Psychologist psychologist;
  private Patient patient;

  public SchedulingOutputDTO (Scheduling scheduling){
    this(scheduling.getId(), scheduling.getAppointmentTime(), scheduling.getPlatform(), scheduling.getPsychologist(), scheduling.getPatient());
  }
}
