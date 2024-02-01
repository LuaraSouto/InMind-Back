package com.senai.inmind.entities;


import com.senai.inmind.dtos.AddressInputDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Address {
    public Address(AddressInputDTO dto){
      this.street = dto.getStreet();
      this.cep = dto.getCep();
      this.city = dto.getCity();
      this.neighborhood = dto.getNeighborhood();
      this.states = dto.getStates();
    }


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String cep;
    private String city;
    private String neighborhood;
    private String states;


}
