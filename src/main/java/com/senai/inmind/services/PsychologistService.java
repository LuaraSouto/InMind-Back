package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.PsychologistInputDTO;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.repositories.AddressRepository;
import com.senai.inmind.repositories.PsychologistRepository;

@Service
@Validated
public class PsychologistService {

    @Autowired
    private PsychologistRepository repository;
    
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Psychologist create(PsychologistInputDTO dto) {
        Psychologist psychologist = new Psychologist(dto);
        if(dto.getAddress() != null){
            var address = addressRepository.save(dto.getAddress());
            psychologist.setAddress(address);
        }
        var passwordEncrypted = new BCryptPasswordEncoder().encode(dto.getPassword());
        psychologist.setPassword(passwordEncrypted);
        Psychologist psychologistCreated = repository.save(psychologist);
        return psychologistCreated;
    }

    public Psychologist read(Long id) {
        return repository.findById(id).get();
    }

    public List<Psychologist> list() {
        return (List<Psychologist>) repository.findAll();
    }

    @Transactional
    public Psychologist update(Psychologist psychologist) {
        if (repository.existsById(psychologist.getId())) {
            return repository.save(psychologist);

        } else {
            return null;
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


    
    //Testes de Sistema, solicitado pelo professor Marcos :D

    public Boolean verificaCRPeCNPJ(Psychologist user) {
        if(user.getCrp() == null && user.getCnpj() == null){
            return false;
        }else{
            return true;
        }
    }

}
