package com.senai.inmind.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressInputDTO {

    private String street;
    private String cep;
    private String city;
    private String neighborhood;
    private String states;

}