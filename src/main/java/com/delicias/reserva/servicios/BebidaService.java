package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Bebida;
import com.delicias.reserva.repositorios.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<Bebida> getAllBebidas() {
        return bebidaRepository.findAll();
    }
}
