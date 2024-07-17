package com.delicias.reserva.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delicias.reserva.modelos.Platos;

@Repository
public interface PlatoRepository extends JpaRepository<Platos, Long> {

}
