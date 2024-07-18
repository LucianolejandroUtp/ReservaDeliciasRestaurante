package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Bebidas;
import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.servicios.BebidaService;
import com.delicias.reserva.servicios.CategoriaService;

@Controller
@RequestMapping("/bebida")
public class BebidaController {
    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = { "/bebidas", "/lista" })
    public String getAllBebidas(Model model) {
        List<Bebidas> bebidas = bebidaService.getAllBebidas();
        List<Categorias> categorias = categoriaService.getAllCategorias();
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("categorias", categorias);
        return "bebida";
    }
}
