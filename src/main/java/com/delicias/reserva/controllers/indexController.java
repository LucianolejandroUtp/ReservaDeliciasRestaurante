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
@RequestMapping
public class indexController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping(path = {"/", "/index"})
    public String index(Model model) {
        List<Distritos> distritos = distritoService.getAllDistritos();
        model.addAttribute("distritos", distritos);

        return "index";
    }

}
