package com.senai.inmind.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
public class ErroDTO {
    private String field;
    private String error;
}
