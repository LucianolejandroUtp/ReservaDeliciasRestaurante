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
}
