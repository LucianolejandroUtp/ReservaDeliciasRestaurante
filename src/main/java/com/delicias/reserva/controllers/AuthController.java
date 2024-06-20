package com.delicias.reserva.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/auth"})
public class AuthController {

    @GetMapping(path = {"/login"})
    public String login() {
        return "auth/login";
    }

//    @GetMapping(path = {"/logout"})
//    public String logout() {
//        return "logout";
//    }
}
