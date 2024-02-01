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

import com.senai.inmind.dtos.UserInputDTO;
import com.senai.inmind.entities.User;
import com.senai.inmind.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
   
    public ResponseEntity<User> post(@RequestBody UserInputDTO user) {
        User usuarioCriado = service.create(user);
        return new ResponseEntity<User>(usuarioCriado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> put(@RequestBody User user) {
        User usuarioAtualizado = service.update(user);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getList() {
        List<User> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> gatRead(@PathVariable Long id) {
        User usuarioEncontrado = service.read(id);
        return ResponseEntity.ok(usuarioEncontrado);
    }
}
