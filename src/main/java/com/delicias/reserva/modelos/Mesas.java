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
@Table(name = "mesas")
public class Mesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nro_mesa", nullable = false)
    private Integer nroMesa;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @ColumnDefault("'DISPONIBLE'")
    @Lob
    @Column(name = "disponibilidad")
    private String disponibilidad;

    @ColumnDefault("'ACTIVO'")
    @Lob
    @Column(name = "estado")
    private String estado;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}