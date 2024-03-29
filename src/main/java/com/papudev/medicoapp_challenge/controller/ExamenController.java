package com.papudev.medicoapp_challenge.controller;

import com.papudev.medicoapp_challenge.exception.ModeloNotFoundException;
import com.papudev.medicoapp_challenge.model.Examen;
import com.papudev.medicoapp_challenge.model.Paciente;
import com.papudev.medicoapp_challenge.service.IExamenService;
import com.papudev.medicoapp_challenge.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private IExamenService service;

    @GetMapping
    public ResponseEntity<List<Examen>> listar() throws Exception{
        List<Examen> list = service.listar();
        return new ResponseEntity<List<Examen>>(list, HttpStatus.OK);
    }

    //nivel de madurez 3
    @GetMapping("/hateoas/{id}")
    public EntityModel<Examen> listarPorIdHateoas(@PathVariable("id") Integer id) throws  Exception{
        Examen obj = service.listarPorId(id);
        if(obj.getIdExamen() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        //localhost:8080/pacientes/{id}
        EntityModel<Examen> recurso = EntityModel.of(obj);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(linkTo.withRel("paciente-recurso"));
        return recurso;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Examen obj = service.listarPorId(id);
        if(obj.getIdExamen() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<Examen>(obj, HttpStatus.OK);
    }

   @PostMapping
   public ResponseEntity<Void> registrar(@Valid @RequestBody Examen examen) throws Exception{
       Examen obj = service.registrar(examen);
       URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExamen()).toUri();
       return ResponseEntity.created(localtion).build();
   }

    @PutMapping
    public ResponseEntity<Examen> modificar(@RequestBody Examen examen) throws Exception{
        Examen obj = service.modificar(examen);
        return new ResponseEntity<Examen>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Examen obj = service.listarPorId(id);
        if(obj.getIdExamen() ==null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
