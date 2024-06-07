package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Distrito;
import com.delicias.reserva.repositorios.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;


    public List<Distrito> getAllDistritos() {
        return distritoRepository.findAll();
    }
}
