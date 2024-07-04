package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Mesas;
import com.delicias.reserva.repositorios.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesas> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Mesas getMesaById(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public void saveMesa(Mesas mesa) {
        mesaRepository.save(mesa);
    }

    public void updateMesa(Mesas mesa) {
        mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}
