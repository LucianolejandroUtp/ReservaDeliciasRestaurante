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
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellido_pat", nullable = false, length = 100)
    private String apellidoPat;

    @Column(name = "apellido_mat", length = 100)
    private String apellidoMat;

    @Column(name = "telefono", length = 100)
    private String telefono;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "referencia", length = 100)
    private String referencia;

    @Column(name = "dni", length = 100)
    private String dni;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

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
    @JoinColumn(name = "distritos_id", nullable = false)
    private Distritos distritos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Roles roles;

}