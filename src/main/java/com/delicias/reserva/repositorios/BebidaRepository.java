package com.delicias.reserva.repositorios;


import com.delicias.reserva.modelos.Bebidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebidas, Long> {
}
