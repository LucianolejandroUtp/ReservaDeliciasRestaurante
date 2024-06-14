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

    public Distrito getDistritoById(Long id) {
        return distritoRepository.findById(id).orElse(null);
    }

    public void saveDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    public void updateDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    public void deleteDistrito(Long id) {
        distritoRepository.deleteById(id);
    }
}
