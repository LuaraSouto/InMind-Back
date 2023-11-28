package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.AvaliationInputDTO;
import com.senai.inmind.entities.Avaliation;
import com.senai.inmind.repositories.AvaliationRepository;

@Service
@Validated
public class AvaliationService {

        
    @Autowired
    private AvaliationRepository repository;

    @Transactional
    public Avaliation create(AvaliationInputDTO dto){
        Avaliation avaliation = new Avaliation(dto);
        Avaliation avaliationCreated = repository.save(avaliation);
        return avaliationCreated;
    }

    public Avaliation read(Long id){
        return repository.findById(id).get();
    }

    public List<Avaliation> list(){
        return (List<Avaliation>) repository.findAll();
    }

    @Transactional
    public Avaliation update(Avaliation avaliation){
        if (repository.existsById(avaliation.getId())) {
            return repository.save(avaliation);
            
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }


}
