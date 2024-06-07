package com.delicias.reserva.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidoP", nullable = false, length = 100)
    private String apellidoP;

    @Column(name = "apellidoM", nullable = false, length = 100)
    private String apellidoM;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "referencia", nullable = false, length = 100)
    private String referencia;

    @Column(name = "dni", nullable = false, length = 100)
    private String dni;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @ColumnDefault("'ACTIVO'")
    @Lob
    @Column(name = "estado", nullable = false)
    private String estado;

    @ColumnDefault("current_timestamp()")
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "distritosId", nullable = false)
    private Distrito distritos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rolesId", nullable = false)
    private Role roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Distrito getDistritos() {
        return distritos;
    }

    public void setDistritos(Distrito distritos) {
        this.distritos = distritos;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

}