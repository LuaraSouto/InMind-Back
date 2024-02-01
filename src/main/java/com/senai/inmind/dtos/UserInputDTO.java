package com.senai.inmind.dtos;

import com.senai.inmind.entities.Address;
import com.senai.inmind.entities.FileInfo;
import com.senai.inmind.entities.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInputDTO {
    @NotBlank
    @Size(max = 255)
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;
    private FileInfo picture;
    @NotNull
    private Role role;
    private Address address;

}
