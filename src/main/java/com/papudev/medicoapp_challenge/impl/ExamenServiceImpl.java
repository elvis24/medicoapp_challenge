package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Examen;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.repository.IExamenRepository;
import com.papudev.medicoapp_challenge.repository.IGenericRepository;
import com.papudev.medicoapp_challenge.repository.IPacienteRepository;
import com.papudev.medicoapp_challenge.service.IExamenService;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {

    @Autowired
    private IExamenRepository examenRepository;

    @Override
    protected IGenericRepository<Examen, Integer> getRepo(){
        return examenRepository;
    }

}
