package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.servicios.DistritoService;

@Controller
@RequestMapping(path = {"/auth"})
public class AuthController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping(path = {"/login"})
    public String login() {
        return "auth/login";
    }

    @GetMapping(path = {"/register"})
    public String register(Model model) {
        List<Distritos> distritos = distritoService.getAllDistritos();
        model.addAttribute("distritos", distritos);
        return "auth/register";
    }

//    @GetMapping(path = {"/logout"})
//    public String logout() {
//        return "logout";
//    }
}
