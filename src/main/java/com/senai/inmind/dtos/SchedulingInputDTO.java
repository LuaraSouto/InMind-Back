package com.senai.inmind.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchedulingInputDTO {

  @NotNull
  private LocalDateTime appointmentTime;
  @NotBlank
  private String platform;
  @NotNull
  private Long psychologist;
  @NotNull
  private Long patient;

}
