package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.modelos.Platos;
import com.delicias.reserva.servicios.CategoriaService;
import com.delicias.reserva.servicios.PlatoService;

@Controller
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = { "/platos", "/lista" })
    public String getAllPlatos(Model model){
        List<Platos> platos = platoService.getAllPlatos();
        List<Categorias> categorias = categoriaService.getAllCategorias();
        model.addAttribute("platos", platos);
        model.addAttribute("categorias", categorias);
        return "plato";
    }
}
