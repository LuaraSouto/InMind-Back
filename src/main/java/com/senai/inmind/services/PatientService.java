package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.PatientInputDTO;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.repositories.AddressRepository;
import com.senai.inmind.repositories.PatientRepository;

@Service
@Validated
public class PatientService {
        
    @Autowired
    private PatientRepository repository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Patient create(PatientInputDTO dto){
        Patient patient = new Patient(dto);
        if(dto.getAddress() != null){
            var address = addressRepository.save(dto.getAddress());
            patient.setAddress(address);
        }
       
        var passwordEncrypted = new BCryptPasswordEncoder().encode(dto.getPassword());
        patient.setPassword(passwordEncrypted);
        Patient patientCreated = repository.save(patient);
        return patientCreated;

    }

    public Patient read(Long id){
        return repository.findById(id).get();
    }

    public List<Patient> list(){
        return (List<Patient>) repository.findAll();
    }

    @Transactional
    public Patient update(Patient patient){
        if (repository.existsById(patient.getId())) {
            return repository.save(patient);
            
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    
    //Testes de Sistema, solicitado pelo professor Marcos :D

    public Boolean varificaCPF(Patient user) {
        if (user.getCpf() == null) {
            return false;
            
        }else{
            return true;
        }
    }

}
