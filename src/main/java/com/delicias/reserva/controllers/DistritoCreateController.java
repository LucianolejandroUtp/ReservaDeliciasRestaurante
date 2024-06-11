package com.delicias.reserva.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/distrito")
public class DistritoCreateController {
    @PostMapping("/create")
    public String create() {
        return "distrito/create";
    }
}
