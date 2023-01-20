package com.papudev.medicoapp_challenge.service;

import com.papudev.medicoapp_challenge.model.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente registrar(Paciente paciente);
    Paciente modificar(Paciente paciente);
    List<Paciente> listar();
    Paciente listarPorId(Integer id);
    void eliminar(Integer id);
}
