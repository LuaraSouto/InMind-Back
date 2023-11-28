package com.senai.inmind;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.senai.inmind.entities.Address;
import com.senai.inmind.entities.User;
import com.senai.inmind.repositories.UserRepository;
import com.senai.inmind.services.UserService;

@ExtendWith(SpringExtension.class)
public class UserServiceTeste {

    @Mock
    private UserRepository repository;
    private Address address;

    @InjectMocks
    private UserService service;

    @Test
    public void isExistEmail() {
    assertTrue(service.isExistEmail("email@email.com", "email2@email.com"));
    assertFalse(service.isExistEmail("email2@email.com", "email2@email.com"));
    }
    @Test
    public void verificarPotenciaSenha() {
    assertTrue(service.verificarPotenciaSenha(" 123456789"));
    assertFalse(service.verificarPotenciaSenha("123"));
    }

    @Test
    public void verificarCredenciaisDoUsuario() {
    var user = new User(1l,"","email@email.com","1234","",true, address);
    assertTrue(service.verificarCredenciaisDoUsuario(user));
    user.setPassword("12345");
    assertTrue(service.verificarCredenciaisDoUsuario(user));
    }
    
    @Test
    public void verificarCampoVazio() {
        var user = new User(null, null, null, null, null, null, null);
        when(repository.save(any(User.class))).thenReturn(user);
        User savedUser = repository.save(user);

        // Verificar se nenhum campo do usuário salvo está nulo
        assertNull(savedUser.getName());
        assertNull(savedUser.getEmail());
        assertNull(savedUser.getPassword());
        assertNull(savedUser.getPicture());
        assertNull(savedUser.getIsAdmin());
        ;

    }
}
