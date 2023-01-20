package com.papudev.medicoapp_challenge.repository;

import com.papudev.medicoapp_challenge.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
