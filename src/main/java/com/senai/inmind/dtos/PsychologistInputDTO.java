package com.senai.inmind.dtos;

import com.senai.inmind.entities.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PsychologistInputDTO {

    private String username;
    private String email;
    private String password;
    private String picture;
    private Address address;

    @NotBlank
    @Size(max = 8, min = 8)
    private String crp;
    @NotBlank
    @Size(max = 14, min = 14)
    private String cnpj;

}