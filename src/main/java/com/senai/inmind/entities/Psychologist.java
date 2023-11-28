package com.senai.inmind.entities;

import com.senai.inmind.dtos.PsychologistInputDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data @AllArgsConstructor @NoArgsConstructor
public class Psychologist extends User{

    public Psychologist(PsychologistInputDTO dto){
        this.crp = dto.getCrp();
        this.cnpj = dto.getCnpj();
        super.username = dto.getUsername();
        super.email = dto.getEmail();
        super.password = dto.getPassword();
       // super.picture = dto.getPicture();
        super.address = dto.getAddress();
    }

    @Column(length = 8)
    private String crp;
    @Column(length = 14)
    private String cnpj;

}
