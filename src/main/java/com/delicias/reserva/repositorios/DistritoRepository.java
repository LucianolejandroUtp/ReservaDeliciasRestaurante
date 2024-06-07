package com.delicias.reserva.repositorios;

import com.delicias.reserva.modelos.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {
}
