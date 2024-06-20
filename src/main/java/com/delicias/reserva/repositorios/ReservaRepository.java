package com.delicias.reserva.repositorios;

import com.delicias.reserva.modelos.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas, Long> {
}
