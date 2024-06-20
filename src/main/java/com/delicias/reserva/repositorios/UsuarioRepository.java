package com.delicias.reserva.repositorios;

import com.delicias.reserva.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByEmail(String email);
}
