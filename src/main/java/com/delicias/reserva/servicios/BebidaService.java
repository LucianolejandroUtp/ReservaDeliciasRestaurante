package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Bebidas;
import com.delicias.reserva.repositorios.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<Bebidas> getAllBebidas() {
        return bebidaRepository.findAll();
    }
    public Bebidas getBebidaById(Long id) {
        return bebidaRepository.findById(id).orElse(null);
    }
    public void saveBebida(Bebidas bebida) {
        bebidaRepository.save(bebida);
    }
    public void updateBebida(Bebidas bebida) {
        bebidaRepository.save(bebida);
    }
    public void deleteBebida(Long id) {
        bebidaRepository.deleteById(id);
    }
}
