package com.delicias.reserva.repositorios;

import com.delicias.reserva.modelos.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
