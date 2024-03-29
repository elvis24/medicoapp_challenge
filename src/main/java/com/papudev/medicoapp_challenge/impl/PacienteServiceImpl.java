package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.repository.IGenericRepository;
import com.papudev.medicoapp_challenge.repository.IPacienteRepository;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    protected IGenericRepository<Paciente, Integer> getRepo(){
        return pacienteRepository;
    }

}
