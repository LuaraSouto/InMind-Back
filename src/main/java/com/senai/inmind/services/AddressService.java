package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.AddressInputDTO;
import com.senai.inmind.entities.Address;
import com.senai.inmind.repositories.AddressRepository;

@Service
@Validated
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Transactional
    public Address create(AddressInputDTO dto){
        Address address = new Address(dto);
        Address addressCreated = repository.save(address);
        return addressCreated;
    }

    public Address read(Long id){
        return repository.findById(id).get();
    }

    public List<Address> list(){
        return (List<Address>) repository.findAll();
    }

    @Transactional
    public Address update(Address address){
        if (repository.existsById(address.getId())) {
            return repository.save(address);
            
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}
