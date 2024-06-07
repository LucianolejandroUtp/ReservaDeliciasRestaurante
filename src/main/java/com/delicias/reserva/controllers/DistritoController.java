package com.delicias.reserva.controllers;

import com.delicias.reserva.modelos.Distrito;
import com.delicias.reserva.servicios.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/prueba")
    public String prueba(@RequestParam(name ="nombre", required = false, defaultValue = "Mundo") String nombre, Model model) {
        System.out.println("Hola mundo");
        model.addAttribute("nombre", nombre);
        return "index";
    }

    @GetMapping(path = {"/distritos", "/lista"})
    public String getAllDistritos(Model model) {

        List<Distrito> distritos = distritoService.getAllDistritos();

        for (Distrito distrito : distritos) {
            System.out.println(distrito.getDescripcion());
        }
//        System.out.println(distritoService.getAllDistritos());
        model.addAttribute("distritos", distritos);

        return "index";
    }
}
