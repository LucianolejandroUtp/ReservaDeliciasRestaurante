package com.delicias.reserva.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("'ACTIVO'")
    @Lob
    @Column(name = "estado")
    private String estado;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reservas_id", nullable = false)
    private Reserva reservas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "platos_id", nullable = false)
    private Plato platos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bebidas_id", nullable = false)
    private Bebida bebidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Reserva getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas = reservas;
    }

    public Plato getPlatos() {
        return platos;
    }

    public void setPlatos(Plato platos) {
        this.platos = platos;
    }

    public Bebida getBebidas() {
        return bebidas;
    }

    public void setBebidas(Bebida bebidas) {
        this.bebidas = bebidas;
    }

}