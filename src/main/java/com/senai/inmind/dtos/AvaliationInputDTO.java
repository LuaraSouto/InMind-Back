package com.senai.inmind.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvaliationInputDTO {
  @NotNull
  private Integer stars;
  private String comment;
  private Long patient;
  private Long psychologist;
}
