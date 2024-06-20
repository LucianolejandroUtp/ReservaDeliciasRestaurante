package com.delicias.reserva.servicios;

import com.delicias.reserva.modelos.Usuario;
import com.delicias.reserva.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            var userObj = usuario.get();
            return User.builder()
                    .username(userObj.getEmail())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }
    }

    private String[] getRoles(Usuario usuario) {
        if (usuario.getRoles().getDescripcion() == null) {
            return new String[]{"USER"};
        } else {
            return usuario.getRoles().getDescripcion().split(",");
        }
    }
}
