package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.repositorios.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;


    public List<Distritos> getAllDistritos() {
        return distritoRepository.findAll();
    }

    public Distritos getDistritoById(Long id) {
        return distritoRepository.findById(id).orElse(null);
    }

    public void saveDistrito(Distritos distrito) {
        distritoRepository.save(distrito);
    }

    public void updateDistrito(Distritos distrito) {
        distritoRepository.save(distrito);
    }

    public void deleteDistrito(Long id) {
        distritoRepository.deleteById(id);
    }
}
