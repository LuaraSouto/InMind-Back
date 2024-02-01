package com.senai.inmind.dtos;

import com.senai.inmind.entities.Address;
//import com.senai.inmind.entities.FileInfo;
import com.senai.inmind.entities.Psychologist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PsychologistOutputDTO {
    
    private String username;
    private String email;
    private String password;
   // private FileInfo picture;
    private Address address;

    private String crp;
    private String cnpj;

    public PsychologistOutputDTO(Psychologist psychologist){
        this(psychologist.getUsername(),psychologist.getEmail(), psychologist.getPassword(), psychologist.getAddress(),psychologist.getCrp(), psychologist.getCnpj());
    }
}
