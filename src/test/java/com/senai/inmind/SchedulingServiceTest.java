package com.senai.inmind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.senai.inmind.dtos.SchedulingInputDTO;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.entities.Psychologist;
import com.senai.inmind.entities.Scheduling;
import com.senai.inmind.repositories.SchedulingRepository;

import com.senai.inmind.services.SchedulingService;

import lombok.var;

@ExtendWith(SpringExtension.class)
public class SchedulingServiceTest {

    @Mock
    private SchedulingRepository repository;

    @InjectMocks
    private SchedulingService service;

    private Psychologist psychologist;
    private Patient patient;

    @Test
    public void criarAgendamentoComDataDisponivel() {
        var date = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        var fernando = new SchedulingInputDTO(date, "Oi", psychologist, patient);
       
        var fernandoScheduling = new Scheduling(fernando);
        when(repository.save(any())).thenReturn(fernandoScheduling);

        var resultado = service.create(fernando);
        assertEquals(resultado.getAppointmentTime(), fernando.getAppointmentTime());
    }

    @Test
    public void criarAgendamentoComDataIndisponivel(){
        var date = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);

        var fernando = new SchedulingInputDTO(date, "Oi", psychologist, patient);
        var dataIndisponivel = new SchedulingInputDTO(date, "Oi", psychologist, patient);

        var fernandoScheduling = new Scheduling(fernando);
        var dataIndisponivelDTO = new Scheduling(dataIndisponivel);

        when(repository.save(any())).thenReturn(dataIndisponivelDTO);
        when(repository.save(any())).thenReturn(fernandoScheduling);
        
        assertEquals(dataIndisponivelDTO.getAppointmentTime(), fernando.getAppointmentTime());
    }
    

    }