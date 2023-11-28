package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.SchedulingInputDTO;
import com.senai.inmind.entities.Scheduling;
import com.senai.inmind.repositories.SchedulingRepository;

@Service
@Validated
public class SchedulingService {
      
    @Autowired
    private SchedulingRepository repository;

    @Transactional
    public Scheduling create(SchedulingInputDTO dto){
        Scheduling scheduling = new Scheduling(dto);
        Scheduling schedulingCreated = repository.save(scheduling);
        return schedulingCreated;
    }

    public Scheduling read(Long id){
        return repository.findById(id).get();
    }

    public List<Scheduling> list(){
        return (List<Scheduling>) repository.findAll();
    }

    @Transactional
    public Scheduling update(Scheduling scheduling){
        if (repository.existsById(scheduling.getId())) {
            return repository.save(scheduling);
            
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}
