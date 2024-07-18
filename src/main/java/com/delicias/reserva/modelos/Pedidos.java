package com.delicias.reserva.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedidos {
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
    private Reservas reservas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "platos_id", nullable = false)
    private Platos platos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bebidas_id", nullable = false)
    private Bebidas bebidas;

}