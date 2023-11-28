package com.senai.inmind.dtos;

import java.time.LocalDate;

import com.senai.inmind.entities.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientInputDTO {

    private String username;
    private String email;
    private String password;
    private String picture;
    private Address address;

    @NotBlank
    @Size(max = 11, min = 11)
    private String cpf;
    @NotNull
    private LocalDate bornDate;
}
