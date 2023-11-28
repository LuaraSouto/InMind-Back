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

import com.senai.inmind.dtos.AvaliationInputDTO;
import com.senai.inmind.entities.Avaliation;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.repositories.AvaliationRepository;
import com.senai.inmind.services.AvaliationService;

@ExtendWith(SpringExtension.class)
public class AvaliationServiceTest {
    
    @Mock
    private AvaliationRepository repository;

    @InjectMocks
    private AvaliationService service;

    Patient patient;
    Psychologist psychologist;

    @Test
    public void criacaoDeAvaliacaoSemComentario(){
         var avaliacaoDTO =  new AvaliationInputDTO(5, null, patient, psychologist);
        var avaliacao = new Avaliation(avaliacaoDTO);
        when(repository.save(any())).thenReturn(avaliacao);
        assertNull(avaliacao.getComment());

    }

    @Test
    public void criacaoDeAvaliacaoCompleto(){
         var avaliacaoDTO =  new AvaliationInputDTO(5, "muito bom recomendo", patient, psychologist);
        var avaliacao = new Avaliation(avaliacaoDTO);
        when(repository.save(any())).thenReturn(avaliacao);
        var resultado = service.create(avaliacaoDTO);
        assertEquals(resultado.getStars(), avaliacao.getStars());
        assertEquals(resultado.getComment(), avaliacao.getComment());
        assertEquals(resultado.getPatient(), avaliacao.getPatient());
        assertEquals(resultado.getPsychologist(), avaliacao.getPsychologist());
    }    

}
