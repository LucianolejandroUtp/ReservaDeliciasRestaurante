package com.delicias.reserva.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.reserva.modelos.Pagos;
import com.delicias.reserva.repositorios.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pagos> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pagos getPagoById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void savePago(Pagos pago) {
        pagoRepository.save(pago);
    }

    public void updatePago(Pagos pago) {
        pagoRepository.save(pago);
    }
    
    public void deletePago(Long id) {
        pagoRepository.deleteById(id);
    }
}
