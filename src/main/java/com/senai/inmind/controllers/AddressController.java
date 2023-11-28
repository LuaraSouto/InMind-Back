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

import com.senai.inmind.dtos.AddressInputDTO;
import com.senai.inmind.entities.Address;
import com.senai.inmind.services.AddressService;

@RestController
@RequestMapping("/addresses")
@CrossOrigin(origins = "http://localhost:5173")
public class AddressController {
    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<Address> post(@RequestBody AddressInputDTO address) {
        Address enderecoCriado = service.create(address);
        return new ResponseEntity<Address>(enderecoCriado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Address> put(@RequestBody Address address) {
        Address enderecoAtualizado = service.update(address);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Address>> getList() {
        List<Address> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> gatRead(@PathVariable Long id) {
        Address enderecoEncontrado = service.read(id);
        return ResponseEntity.ok(enderecoEncontrado);
    }
}
