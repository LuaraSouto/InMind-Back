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

import com.senai.inmind.dtos.AvaliationInputDTO;
import com.senai.inmind.entities.Avaliation;
import com.senai.inmind.services.AvaliationService;

@RestController
@RequestMapping("/avaliations")
@CrossOrigin(origins = "http://localhost:5173")
public class AvaliationController {
    @Autowired
    private AvaliationService service;

    @PostMapping
    public ResponseEntity<Avaliation> post(@RequestBody AvaliationInputDTO avaliation) {
        Avaliation avaliacaoCriada = service.create(avaliation);
        return new ResponseEntity<Avaliation>(avaliacaoCriada, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Avaliation> put(@RequestBody Avaliation avaliation) {
        Avaliation avaliacaoAtualizada = service.update(avaliation);
        return ResponseEntity.ok(avaliacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Avaliation>> getList() {
        List<Avaliation> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliation> gatRead(@PathVariable Long id) {
        Avaliation avaliacaoEncontrada = service.read(id);
        return ResponseEntity.ok(avaliacaoEncontrada);
    }
}
