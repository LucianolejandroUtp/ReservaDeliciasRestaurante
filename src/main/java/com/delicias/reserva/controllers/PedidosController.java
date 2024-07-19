package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.modelos.Pedidos;
import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.servicios.DistritoService;
import com.delicias.reserva.servicios.PedidoService;
import com.delicias.reserva.servicios.RolService;

@Controller
@RequestMapping("/pedido")
public class PedidosController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private DistritoService distritoService;
    @Autowired
    private RolService rolService;

    @GetMapping(path = { "/pedidos", "/lista" })
    public String getAllPedidos(Model model) {
        List<Pedidos> pedidos = pedidoService.getAllPedidos();
        List<Distritos> distritos = distritoService.getAllDistritos();
        List<Roles> roles = rolService.getAllRoles();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("distritos", distritos);
        model.addAttribute("roles", roles);
        return "pedido";
    }

}
