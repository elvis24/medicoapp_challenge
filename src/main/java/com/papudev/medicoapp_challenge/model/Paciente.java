package com.papudev.medicoapp_challenge.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;
    @Schema(description = "nombres del paciente")
    @Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
    @Column(name = "nombres", nullable = false,length = 70)
    private String nombres;
    @NotNull
    @Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")//constrain
    @Column(name = "apellidos", nullable = false,length = 70)
    private String apellidos;
    @Size(min = 8, max = 8, message = "DNI debe tener minimo 8 caracteres")
    @Column(name = "dni", nullable = false,length = 8)
    private String dni;
    @Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres")
    @Column(name = "direccion", nullable = true,length = 150)
    private String direccion;
    @Size(min = 9, max = 9, message = "Telefono debe tener minimo 9 caracteres")
    @Column(name = "telefono", nullable = true,length = 20)
    private String telefono;
    @Email
    @Column(name = "email", nullable = true,length = 55)
    private String email;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
