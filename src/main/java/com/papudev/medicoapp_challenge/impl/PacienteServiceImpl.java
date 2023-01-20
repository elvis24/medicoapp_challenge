package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.repository.IPacienteRepository;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente listarPorId(Integer id) {
        Optional<Paciente> op = pacienteRepository.findById(id);
        return op.isPresent() ? op.get() : new Paciente();
    }

    @Override
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);

    }
}
