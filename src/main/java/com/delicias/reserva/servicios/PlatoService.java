package com.delicias.reserva.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.reserva.modelos.Platos;
import com.delicias.reserva.repositorios.PlatoRepository;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Platos> getAllPlatos() {
        return platoRepository.findAll();
    }
    public Platos getPlatoById(Long id) {
        return platoRepository.findById(id).orElse(null);
    }
    public void savePlato(Platos plato) {
        platoRepository.save(plato);
    }
    public void updatePlato(Platos plato) {
        platoRepository.save(plato);
    }
    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }
}
