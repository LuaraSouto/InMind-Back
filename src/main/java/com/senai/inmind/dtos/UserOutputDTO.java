package com.senai.inmind.dtos;

import com.senai.inmind.entities.Address;
import com.senai.inmind.entities.FileInfo;
import com.senai.inmind.entities.Role;
import com.senai.inmind.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserOutputDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private FileInfo picture;
    private Address address;

    public UserOutputDTO(User user){
        this(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),user.getRole(), user.getPicture(), user.getAddress());
    }
    
}

