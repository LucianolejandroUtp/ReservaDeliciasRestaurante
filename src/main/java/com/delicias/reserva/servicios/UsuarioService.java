package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Usuarios;
import com.delicias.reserva.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuarios getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void saveUsuario(Usuarios usuario) {
        usuarioRepository.save(usuario);
    }

    public void updateUsuario(Usuarios usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
