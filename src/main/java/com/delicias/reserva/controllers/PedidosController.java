package com.delicias.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delicias.reserva.modelos.Bebidas;
import com.delicias.reserva.modelos.Pedidos;
import com.delicias.reserva.modelos.Platos;
import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.servicios.BebidaService;
import com.delicias.reserva.servicios.PedidoService;
import com.delicias.reserva.servicios.PlatoService;
import com.delicias.reserva.servicios.ReservaService;

@Controller
@RequestMapping("/pedido")
public class PedidosController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private PlatoService platoService;
    @Autowired
    private BebidaService bebidaService;

    @GetMapping(path = { "/pedidos", "/lista" })
    public String getAllPedidos(Model model) {
        List<Pedidos> pedidos = pedidoService.getAllPedidos();
        List<Reservas> reservas = reservaService.getAllReservas();
        List<Platos> platos = platoService.getAllPlatos();
        List<Bebidas> bebidas = bebidaService.getAllBebidas();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("reservas", reservas);
        model.addAttribute("platos", platos);
        model.addAttribute("bebidas", bebidas);
        return "pedido";
    }

    @PostMapping("/create")
    public String create(
        @RequestParam(name = "createDato01", required = false) String dato01,
            @RequestParam(name = "createDato20", required = false) Long dato20,
            @RequestParam(name = "createDato21", required = false) Long dato21,
            @RequestParam(name = "createDato22", required = false) Long dato22,
            @RequestParam(name = "createDato23", required = false) Long dato23){
        Reservas miReserva = reservaService.getReservaById(dato20);
        Platos miPlato = platoService.getPlatoById(dato21);
        Bebidas miBebida = bebidaService.getBebidaById(dato22);

        Pedidos miPedido = new Pedidos();
        miPedido.setReservas(miReserva);
        miPedido.setPlatos(miPlato);
        miPedido.setBebidas(miBebida);

        pedidoService.savePedido(miPedido);
        return "redirect:/pedido/lista";
    }

    //Método para obtener los datos de un plato por ID (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> obtenerPedido(@PathVariable Long id){
        Pedidos pedido = pedidoService.getPedidoById(id);
        return ResponseEntity.ok(pedido);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
