package com.senai.inmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.inmind.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
