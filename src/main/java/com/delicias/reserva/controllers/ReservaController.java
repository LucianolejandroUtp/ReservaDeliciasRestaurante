package com.delicias.reserva.controllers;

import com.delicias.reserva.modelos.Bebida;
import com.delicias.reserva.modelos.Reserva;
import com.delicias.reserva.modelos.Usuario;
import com.delicias.reserva.servicios.BebidaService;
import com.delicias.reserva.servicios.ReservaService;
import com.delicias.reserva.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = {"/reservas", "/lista"})
    public String getAllReservas(Model model) {
        List<Reserva> reservas = reservaService.getAllReservas();
        List<Bebida> bebidas = bebidaService.getAllBebidas();
        List<Usuario> usuarios = usuarioService.getAllUsuarios();

        model.addAttribute("reservas", reservas);
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("usuarios", usuarios);
        return "reserva";
    }


    @PostMapping("/create")
    public String create(
            @RequestParam(name ="dato1", required = false) String dato1,
            @RequestParam(name ="dato2", required = false) String dato2,
            @RequestParam(name ="dato3", required = false) String dato3,
            @RequestParam(name ="dato4", required = false) String dato4,
            @RequestParam(name ="dato5", required = false) String dato5,
            @RequestParam(name ="dato6", required = false) String dato6
            ) {

        System.out.println("---" + dato1 + "---");
        System.out.println("---" + dato2 + "---");
        System.out.println("---" + dato3 + "---");
        System.out.println("---" + dato4 + "---");
        System.out.println("---" + dato5 + "---");
        System.out.println("---" + dato6 + "---");
        DateTimeFormatter formatoEntradaFecha = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatoEntradaHora = DateTimeFormatter.ofPattern("hh:mm a");

        // Convierte la fecha String al formato deseado
        LocalDate fecha = LocalDate.parse(dato1, formatoEntradaFecha);
        LocalTime hora = LocalTime.parse(dato2.toUpperCase(), formatoEntradaHora);

        System.out.println("Fecha formateada: " + fecha);
        System.out.println("Hora formateada: " + hora);


        Usuario miUsuario = usuarioService.getUsuarioById(Long.parseLong(dato6));

        Reserva miReserva = new Reserva();


        miReserva.setFecha(fecha);
        miReserva.setHora(hora);
        miReserva.setNroPersonas(Integer.parseInt(dato3));
        miReserva.setUsuarios(miUsuario);

        reservaService.saveReserva(miReserva);

        return "redirect:/distrito/lista";
    }


}
