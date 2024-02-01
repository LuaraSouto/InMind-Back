package com.senai.inmind.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.inmind.dtos.PatientInputDTO;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.services.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<Patient> post(@RequestBody PatientInputDTO patient) {
        Patient pacienteCriado = service.create(patient);
        return new ResponseEntity<Patient>(pacienteCriado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Patient> put(@RequestBody Patient patient) {
        Patient pacienteAtualizado = service.update(patient);
        return ResponseEntity.ok(pacienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getList() {
        List<Patient> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> gatRead(@PathVariable Long id) {
        Patient pacienteEncontrado = service.read(id);
        return ResponseEntity.ok(pacienteEncontrado);
    }
}
