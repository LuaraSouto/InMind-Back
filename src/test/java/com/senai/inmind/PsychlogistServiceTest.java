package com.senai.inmind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.senai.inmind.dtos.PsychologistInputDTO;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.repositories.PsychologistRepository;
import com.senai.inmind.services.PsychologistService;

import lombok.var;

@ExtendWith(SpringExtension.class)
public class PsychlogistServiceTest {

    @Mock
    private PsychologistRepository repository;

    @InjectMocks
    private PsychologistService service;

    @Test
    public void criarPsicologoComCRP() {
        var fernandoDTO = new PsychologistInputDTO("12345678", "12345678910111", 100f);
        var fernando = new Psychologist(fernandoDTO);
        when(repository.save(any())).thenReturn(fernando);
        var resultado = service.create(fernandoDTO);
        assertEquals(resultado.getCrp(), fernando.getCrp());
    }


    @Test
    public void criarPsicologoComCNPJ() {
        var fernandoDTO = new PsychologistInputDTO("12345678", "12345678910111", 100f);
        var fernando = new Psychologist(fernandoDTO);
        when(repository.save(any())).thenReturn(fernando);
        var resultado = service.create(fernandoDTO);
        assertEquals(resultado.getCnpj(), fernando.getCnpj());
    }

    @Test
    public void validaacoCRPeCNPJ() {
        var fernandoDTO = new PsychologistInputDTO(null, null, 100f);
        var fernando = new Psychologist(fernandoDTO);
        when(repository.save(any())).thenReturn(fernando);
        assertFalse(service.verificaCRPeCNPJ(fernando));

        var fernandoDTOCompleto = new PsychologistInputDTO("2313213213", "12345678910111", 100f);
        var fernandoCompleto = new Psychologist(fernandoDTOCompleto);
        when(repository.save(any())).thenReturn(fernandoCompleto);
        assertTrue(service.verificaCRPeCNPJ(fernandoCompleto));


    }

}
