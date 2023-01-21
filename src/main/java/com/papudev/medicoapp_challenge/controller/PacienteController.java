package com.papudev.medicoapp_challenge.controller;

import com.papudev.medicoapp_challenge.exception.ModeloNotFoundException;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> list = service.listar();
        return new ResponseEntity<List<Paciente>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id){
        Paciente obj = service.listarPorId(id);
        if(obj.getIdPaciente() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente){
        Paciente obj = service.modificar(paciente);
        return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente){
        Paciente obj = service.modificar(paciente);
        return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id){
        Paciente obj = service.listarPorId(id);
        if(obj.getIdPaciente() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
