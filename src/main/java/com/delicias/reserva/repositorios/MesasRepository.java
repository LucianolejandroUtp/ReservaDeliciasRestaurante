package com.delicias.reserva.repositorios;

import com.delicias.reserva.modelos.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Long> {
}