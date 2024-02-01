package com.senai.inmind.dtos;

import com.senai.inmind.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressOutputDTO {

    private Long id;
    private String street;
    private String cep;
    private String city;
    private String neighborhood;
    private String states;

    public AddressOutputDTO (Address address){
        this(address.getId(), address.getStreet(), address.getCep(), address.getCity(), address.getNeighborhood(), address.getStates());
    }
}
