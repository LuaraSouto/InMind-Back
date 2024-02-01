package com.senai.inmind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.senai.inmind.dtos.AddressInputDTO;
import com.senai.inmind.entities.Address;
import com.senai.inmind.repositories.AddressRepository;
import com.senai.inmind.services.AddressService;

@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository repository;

    @InjectMocks
    private AddressService service;

    @Test
    public void criarEnderecoCompleto() {
        var enderecoDTO = new AddressInputDTO("RuaRua", ",00000-000", "CidadeCidade", "BairroBairro", "EstadoEstado");
        var endereco = new Address(enderecoDTO);
        when(repository.save(any())).thenReturn(endereco);
        var resultado = service.create(enderecoDTO);
        assertEquals(resultado.getStreet(), endereco.getStreet());
        assertEquals(resultado.getCep(), endereco.getCep());
        assertEquals(resultado.getCity(), endereco.getCity());
        assertEquals(resultado.getNeighborhood(), endereco.getNeighborhood());
        assertEquals(resultado.getStates(), endereco.getStates());

    }

    @Test
    public void criarEnderecoNaoCompleto() {
        var enderecoDTO = new AddressInputDTO(null, null, null, null, null);
        var endereco = new Address(enderecoDTO);
        when(repository.save(any())).thenReturn(endereco);
        assertNull(endereco.getStreet());
        assertNull(endereco.getCep());
        assertNull(endereco.getCity());
        assertNull(endereco.getNeighborhood());
        assertNull(endereco.getStates());

    }

}
