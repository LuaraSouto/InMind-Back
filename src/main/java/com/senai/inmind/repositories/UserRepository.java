package com.senai.inmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.inmind.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername(String name);
}
