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

import com.senai.inmind.dtos.SchedulingInputDTO;
import com.senai.inmind.entities.Scheduling;
import com.senai.inmind.services.SchedulingService;

@RestController
@RequestMapping("/schedulings")
@CrossOrigin(origins = "http://localhost:5173")
public class SchedulingController {
    @Autowired
    private SchedulingService service;

    @PostMapping
    public ResponseEntity<Scheduling> post(@RequestBody SchedulingInputDTO scheduling) {
        Scheduling agendamentoCriado = service.create(scheduling);
        return new ResponseEntity<Scheduling>(agendamentoCriado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Scheduling> put(@RequestBody Scheduling scheduling) {
        Scheduling agendamentoAtualizado = service.update(scheduling);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Scheduling>> getList() {
        List<Scheduling> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheduling> gatRead(@PathVariable Long id) {
        Scheduling agendamentoEncontrado = service.read(id);
        return ResponseEntity.ok(agendamentoEncontrado);
    }
}
