package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.servicios.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = {"/categorias", "/lista"})
    public String getAllCategorias(Model model) {
        List<Categorias> categorias = categoriaService.getAllCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }
}
