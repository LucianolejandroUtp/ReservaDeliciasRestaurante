package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.servicios.RolService;


@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping(path = {"/roles", "/lista"})
    public String getAllRoles(Model model) {
        List<Roles> roles = rolService.getAllRoles();
        model.addAttribute("roles", roles);
        return "rol";
    }
}
