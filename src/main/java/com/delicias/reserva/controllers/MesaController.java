package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Mesas;
import com.delicias.reserva.servicios.MesaService;


@Controller
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;
    
    @GetMapping(path = { "/mesas", "/lista" })
    public String getAllMesas(Model model) {    
        List<Mesas> mesas = mesaService.getAllMesas();
        model.addAttribute("mesas", mesas);
        return "mesa";
    }
}
