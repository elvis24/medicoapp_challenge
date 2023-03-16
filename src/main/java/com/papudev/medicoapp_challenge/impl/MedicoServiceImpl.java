package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Medico;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.repository.IGenericRepository;
import com.papudev.medicoapp_challenge.repository.IMedicoRepository;
import com.papudev.medicoapp_challenge.repository.IPacienteRepository;
import com.papudev.medicoapp_challenge.service.IMedicoService;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Override
    protected IGenericRepository<Medico, Integer> getRepo() {
        return medicoRepository;
    }

}
