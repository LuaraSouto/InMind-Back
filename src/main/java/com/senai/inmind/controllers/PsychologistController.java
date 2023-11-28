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

import com.senai.inmind.dtos.PsychologistInputDTO;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.services.PsychologistService;

@RestController
@RequestMapping("/psychologists")
@CrossOrigin(origins = "http://localhost:5173")
public class PsychologistController {
    @Autowired
    private PsychologistService service;

    @PostMapping
    public ResponseEntity<Psychologist> post(@RequestBody PsychologistInputDTO psychologist) {
        Psychologist psicologoCriado = service.create(psychologist);
        return new ResponseEntity<Psychologist>(psicologoCriado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Psychologist> put(@RequestBody Psychologist psychologist) {
        Psychologist psicologoAtualizado = service.update(psychologist);
        return ResponseEntity.ok(psicologoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Psychologist>> getList() {
        List<Psychologist> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Psychologist> gatRead(@PathVariable Long id) {
        Psychologist psicologoEncontrado = service.read(id);
        return ResponseEntity.ok(psicologoEncontrado);
    }
}
