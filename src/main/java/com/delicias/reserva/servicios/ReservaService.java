package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.repositorios.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;


    public List<Reservas> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reservas getReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void saveReserva(Reservas reserva) {
        reservaRepository.save(reserva);
    }

    public void updateReserva(Reservas reserva) {
        reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
