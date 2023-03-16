package com.papudev.medicoapp_challenge.repository;

import com.papudev.medicoapp_challenge.model.Medico;
import com.papudev.medicoapp_challenge.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends IGenericRepository<Medico, Integer> {
}
