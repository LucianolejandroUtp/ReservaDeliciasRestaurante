package com.delicias.reserva.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.repositorios.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Roles> getAllRoles() {
        return rolRepository.findAll();
    }

    public Roles getRolById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void saveRol(Roles rol) {
        rolRepository.save(rol);
    }

    public void updateRol(Roles rol) {
        rolRepository.save(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
