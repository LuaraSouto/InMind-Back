package com.senai.inmind.dtos;

import java.time.LocalDate;

import com.senai.inmind.entities.Address;
//import com.senai.inmind.entities.FileInfo;
import com.senai.inmind.entities.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientOutputDTO {

    private String username;
    private String email;
    private String password;
    // private FileInfo picture;
    private Address address;

    private String cpf;
    private LocalDate bornDate;

    public PatientOutputDTO(Patient patient){
        this(patient.getUsername(),patient.getEmail(), patient.getPassword(), patient.getAddress(),patient.getCpf(), patient.getBornDate());
    }
}
