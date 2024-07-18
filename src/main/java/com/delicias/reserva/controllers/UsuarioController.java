package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.modelos.Usuarios;
import com.delicias.reserva.servicios.DistritoService;
import com.delicias.reserva.servicios.RolService;
import com.delicias.reserva.servicios.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DistritoService distritoService;
    
    @Autowired
    private RolService rolService;

    @GetMapping(path = { "/usuarios", "/lista" })
    public String getAllUsuarios(Model model) {
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();
        List<Distritos> distritos = distritoService.getAllDistritos();
        List<Roles> roles = rolService.getAllRoles();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("distritos", distritos);
        model.addAttribute("roles", roles);
        return "usuario";
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete (@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
