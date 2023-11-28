package com.senai.inmind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.senai.inmind.dtos.PatientInputDTO;
import com.senai.inmind.entities.Patient;
import com.senai.inmind.repositories.PatientRepository;
import com.senai.inmind.services.PatientService;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository repository;

    @InjectMocks
    private PatientService service;

    @Test
    public void criarPacienteComCpf() {
        var date = LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC);
        var fernandoDTO = new PatientInputDTO(null, null, null, null, null,"12345678", date);
        var fernando = new Patient(fernandoDTO);
        when(repository.save(any())).thenReturn(fernando);
        var resultado = service.create(fernandoDTO);
        assertEquals(resultado.getCpf(), fernando.getCpf());
    }

    @Test
    public void criarPacienteSemCpf() {
        var date = LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC);
        var fernandoDTO = new PatientInputDTO(null, null, null, null, null, "12345678",  date);
        var fernando = new Patient(fernandoDTO);
        when(repository.save(any())).thenReturn(fernando);
        var resultado = service.create(fernandoDTO);
        assertNull(resultado.getCpf());

    }

    @Test
    public void criarPacienteSemDate() {

        var fernadoDTO = new PatientInputDTO(null, null, null, null, null, "12345678", null);
        var fernando = new Patient(fernadoDTO);
        when(repository.save(any())).thenReturn(fernando);
        var resultado = service.create(fernadoDTO);
        when(repository.save(any())).thenReturn(fernando);
        assertNull(resultado.getBornDate());
    }

    @Test
    public void verificarCPF() {
        var userDTO = new PatientInputDTO(null, null, null, null, null, "12345678", null);
        var user = new Patient(userDTO);
        when(repository.save(any())).thenReturn(user);

        var date = LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC);
        var userCompletoDTO = new PatientInputDTO(null, null, null, null, null, "12345678",  date);
        var userCompleto = new Patient(userCompletoDTO);
        when(repository.save(any())).thenReturn(userCompleto);
        

        assertTrue(service.varificaCPF(userCompleto));
        assertFalse(service.varificaCPF(user));


    }

    // Não consegui fazer funcionar!!!!!
    // @Test
    // public void pacienteDeletaConta() {
    // var data = LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC);
    // var carlosDTO = new PatientInputDTO("12345678", data);
    // var carlos = new Patient(carlosDTO);
    // when(repository.save(any())).thenReturn(carlos);
    // service.create(carlosDTO); // Salva o paciente primeiro
    // // repository.delete(carlosDTO);
    // // assertNull(carlos);
    // }
}
