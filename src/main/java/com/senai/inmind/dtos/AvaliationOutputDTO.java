package com.senai.inmind.dtos;

import com.senai.inmind.entities.Avaliation;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.entities.Psychologist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvaliationOutputDTO {
    private Long id;
    private Integer stars;
    private String comment;
    private Patient patient;

    private Psychologist psychologist;

    public AvaliationOutputDTO(Avaliation avaliation) {
        this(avaliation.getId(), avaliation.getStars(), avaliation.getComment(), avaliation.getPatient(),
                avaliation.getPsychologist());
    }
}
