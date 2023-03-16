package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Especialidad;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.repository.IEspecialidadRepository;
import com.papudev.medicoapp_challenge.repository.IGenericRepository;
import com.papudev.medicoapp_challenge.repository.IPacienteRepository;
import com.papudev.medicoapp_challenge.service.IEspecialidadService;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;

    @Override
    protected IGenericRepository<Especialidad, Integer> getRepo(){
        return especialidadRepository;
    }

}
