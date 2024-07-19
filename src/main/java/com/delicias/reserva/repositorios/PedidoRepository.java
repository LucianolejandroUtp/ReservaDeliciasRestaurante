package com.delicias.reserva.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delicias.reserva.modelos.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long> {

}
