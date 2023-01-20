package com.papudev.medicoapp_challenge.controller;

import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping
    public List<Paciente> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Paciente listarPorId(@PathVariable("id") Integer id){
        return service.listarPorId(id);
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente){
        return service.registrar(paciente);
    }

    @PutMapping
    public Paciente modificar(@RequestBody Paciente paciente){
        return service.registrar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
                service.eliminar(id);
    }
}
