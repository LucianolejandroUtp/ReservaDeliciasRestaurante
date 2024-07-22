package com.delicias.reserva.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delicias.reserva.modelos.Pagos;
import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.servicios.PagoService;
import com.delicias.reserva.servicios.ReservaService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    private PagoService pagoService;
    @Autowired
    private ReservaService reservaService;

    @GetMapping(path = { "/pagos", "/lista" })
    public String getAllPagos(Model model) {
        List<Pagos> pagos = pagoService.getAllPagos();
        List<Reservas> reservas = reservaService.getAllReservas();
        model.addAttribute("pagos", pagos);
        model.addAttribute("reservas", reservas);

        pagos.forEach(p -> {
            System.out.println("Pago: " + p.getId() + " - " + p.getMonto() + " - " + p.getFecha() + " - " + p.getHora() + " - " + p.getTipo() + " - " + p.getEstado() + " - ");
            p.getReservas().getPedidos().forEach(pe -> {
                System.out.println("Pedido: " + pe.getId() + " - " + pe.getPlatos().getNombre() + " - " + pe.getBebidas().getNombre());
            });
        });

        return "pago";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam(name = "createDato01", required = false) int dato01,
            @RequestParam(name = "createDato02", required = false) String dato02,
            @RequestParam(name = "createDato03", required = false) String dato03,
            @RequestParam(name = "createDato04", required = false) String dato04,
            @RequestParam(name = "createDato05", required = false) String dato05,
            @RequestParam(name = "createDato06", required = false) String dato06,
            @RequestParam(name = "createDato07", required = false) String dato07,
            @RequestParam(name = "createDato08", required = false) String dato08,
            @RequestParam(name = "createDato09", required = false) String dato09,
            @RequestParam(name = "createDato10", required = false) String dato10,
            @RequestParam(name = "createDato15", required = false) String dato15,
            @RequestParam(name = "createDato20", required = false) String dato20) {
        Reservas miReserva = reservaService.getReservaById(Long.parseLong(dato20));

        DateTimeFormatter formatoEntradaFecha = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatoEntradaHora = DateTimeFormatter.ofPattern("hh:mm a");

        // Convierte la fecha String al formato deseado
        LocalDate fecha = LocalDate.parse(dato02, formatoEntradaFecha);
        LocalTime hora = LocalTime.parse(dato03.toUpperCase(), formatoEntradaHora);

        System.out.println("Fecha formateada: " + fecha);
        System.out.println("Hora formateada: " + hora);

        Pagos miPago = new Pagos();
        miPago.setMonto(dato01);
        miPago.setFecha(fecha);
        miPago.setHora(hora);
        miPago.setTipo(dato04);
        miPago.setEstado(dato15);
        miPago.setReservas(miReserva);

        pagoService.savePago(miPago);

        return "redirect:/pago/lista";
    }

}
