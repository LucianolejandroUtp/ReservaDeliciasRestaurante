package com.delicias.reserva.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "nroPersonas", nullable = false)
    private Integer nroPersonas;

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
    @JoinColumn(name = "bebidasId", nullable = false)
    private Bebida bebidas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "platosId", nullable = false)
    private Plato platos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getNroPersonas() {
        return nroPersonas;
    }

    public void setNroPersonas(Integer nroPersonas) {
        this.nroPersonas = nroPersonas;
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

    public Bebida getBebidas() {
        return bebidas;
    }

    public void setBebidas(Bebida bebidas) {
        this.bebidas = bebidas;
    }

    public Plato getPlatos() {
        return platos;
    }

    public void setPlatos(Plato platos) {
        this.platos = platos;
    }

}