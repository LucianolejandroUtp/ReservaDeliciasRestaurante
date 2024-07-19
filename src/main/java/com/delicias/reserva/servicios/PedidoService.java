package com.delicias.reserva.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.reserva.modelos.Pedidos;
import com.delicias.reserva.repositorios.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedidos> getAllPedidos() {
        return pedidoRepository.findAll();
    }
    public Pedidos getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    public void savePedido(Pedidos pedido) {
        pedidoRepository.save(pedido);
    }
    public void updatePedido(Pedidos pedido) {
        pedidoRepository.save(pedido);
    }
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}
