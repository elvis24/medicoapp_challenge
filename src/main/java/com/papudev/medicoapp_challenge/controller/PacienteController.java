package com.papudev.medicoapp_challenge.controller;

import com.papudev.medicoapp_challenge.exception.ModeloNotFoundException;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.persistence.Id;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() throws Exception{
        List<Paciente> list = service.listar();
        return new ResponseEntity<List<Paciente>>(list, HttpStatus.OK);
    }

    //nivel de madurez 3
    @GetMapping("/hateoas/{id}")
    public EntityModel<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) throws  Exception{
        Paciente obj = service.listarPorId(id);
        if(obj.getIdPaciente() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        //localhost:8080/pacientes/{id}
        EntityModel<Paciente> recurso = EntityModel.of(obj);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(linkTo.withRel("paciente-recurso"));
        return recurso;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Paciente obj = service.listarPorId(id);
        if(obj.getIdPaciente() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
    }

   /* @PostMapping
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente){
        Paciente obj = service.modificar(paciente);
        return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
    }*/
   @PostMapping
   public ResponseEntity<Void> registrar(@Valid @RequestBody Paciente paciente) throws Exception{
       Paciente obj = service.registrar(paciente);
       URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
       return ResponseEntity.created(localtion).build();
   }

    @PutMapping
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) throws Exception{
        Paciente obj = service.modificar(paciente);
        return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Paciente obj = service.listarPorId(id);
        if(obj.getIdPaciente() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
