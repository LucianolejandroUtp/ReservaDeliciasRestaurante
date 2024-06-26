package com.delicias.reserva.controllers;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.modelos.Mesas;
import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.modelos.Usuarios;
import com.delicias.reserva.servicios.MesaService;
import com.delicias.reserva.servicios.ReservaService;
import com.delicias.reserva.servicios.UsuarioService;
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
    private MesaService mesaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = { "/reservas", "/lista" })
    public String getAllReservas(Model model) {
        List<Reservas> reservas = reservaService.getAllReservas();
        List<Mesas> mesas = mesaService.getAllMesas();
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();

        model.addAttribute("reservas", reservas);
        model.addAttribute("mesas", mesas);
        model.addAttribute("usuarios", usuarios);
        return "reserva";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "dato1", required = false) String dato1,
            @RequestParam(name = "dato2", required = false) String dato2,
            @RequestParam(name = "dato3", required = false) String dato3,
            // @RequestParam(name ="dato4", required = false) String dato4,
            // @RequestParam(name ="dato5", required = false) String dato5,
            @RequestParam(name = "dato6", required = false) String dato6,
            @RequestParam(name = "dato7", required = false) String dato7) {

        System.out.println("---" + dato1 + "---");
        System.out.println("---" + dato2 + "---");
        System.out.println("---" + dato3 + "---");
        // System.out.println("---" + dato4 + "---");
        // System.out.println("---" + dato5 + "---");
        System.out.println("---" + dato6 + "---");
        DateTimeFormatter formatoEntradaFecha = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatoEntradaHora = DateTimeFormatter.ofPattern("hh:mm a");

        // Convierte la fecha String al formato deseado
        LocalDate fecha = LocalDate.parse(dato1, formatoEntradaFecha);
        LocalTime hora = LocalTime.parse(dato2.toUpperCase(), formatoEntradaHora);

        System.out.println("Fecha formateada: " + fecha);
        System.out.println("Hora formateada: " + hora);

        Usuarios miUsuario = usuarioService.getUsuarioById(Long.parseLong(dato6));
        Mesas miMesa = mesaService.getMesaById(Long.parseLong(dato7));

        Reservas miReserva = new Reservas();

        miReserva.setFecha(fecha);
        miReserva.setHora(hora);
        miReserva.setNroPersonas(Integer.parseInt(dato3));
        miReserva.setUsuarios(miUsuario);
        miReserva.setMesas(miMesa);

        reservaService.saveReserva(miReserva);

        return "redirect:/distrito/lista";
    }

    // Método para obtener los datos de un distrito por ID (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Reservas> obtenerReserva(@PathVariable Long id) {
        Reservas reserva = reservaService.getReservaById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Distrito inválido Id:" + id));
        return ResponseEntity.ok(reserva); // Devolver los datos del distrito en formato JSON
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }

}
