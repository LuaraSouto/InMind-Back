package com.senai.inmind.entities;

import com.senai.inmind.dtos.AvaliationInputDTO;

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
public class Avaliation {
  public Avaliation(AvaliationInputDTO dto) {
    this.stars = dto.getStars();
    this.comment = dto.getComment();
    this.psychologist = new Psychologist();
    this.psychologist.setId(dto.getPsychologist());
    this.patient = new Patient();
    this.patient.setId(dto.getPatient());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer stars;
  private String comment;
  @ManyToOne(optional = true)
  private Patient patient;
  @ManyToOne(optional = true)
  private Psychologist psychologist;
}
