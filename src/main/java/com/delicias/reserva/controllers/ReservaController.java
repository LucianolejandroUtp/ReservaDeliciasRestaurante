package com.delicias.reserva.controllers;

import com.delicias.reserva.modelos.Mesas;
import com.delicias.reserva.modelos.Pagos;
import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.modelos.Usuarios;
import com.delicias.reserva.servicios.MesaService;
import com.delicias.reserva.servicios.MyUserDetailService;
import com.delicias.reserva.servicios.PagoService;
import com.delicias.reserva.servicios.ReservaService;
import com.delicias.reserva.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private PagoService pagoService;
    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping(path = { "/reservas", "/lista" })
    public String getAllReservas(Model model) {
        List<Reservas> reservas = reservaService.getAllReservas();
        List<Mesas> mesas = mesaService.getAllMesas();
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();

        model.addAttribute("reservas", reservas);
        model.addAttribute("mesas", mesas);
        model.addAttribute("usuarios", usuarios);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {       
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();

            UserDetails uD = myUserDetailService.loadUserByUsername(email);
            String concatAuth = uD.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
           
            model.addAttribute("email", email);
            model.addAttribute("concatAuth", concatAuth);
        }
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
        LocalTime hora = LocalTime.parse(dato2, formatoEntradaHora);

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

        return "redirect:/reserva/lista";
    }

    // Método para obtener los datos de un distrito por ID (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Reservas> obtenerReserva(@PathVariable Long id) {
        Reservas reserva = reservaService.getReservaById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Distrito inválido Id:" + id));
        return ResponseEntity.ok(reserva); // Devolver los datos del distrito en formato JSON
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Reservas miObjeto) {
        Reservas reservaDB = reservaService.getReservaById(id);
        Mesas mesaDB = mesaService.getMesaById(miObjeto.getMesas().getId());
        Usuarios usuarioDB = usuarioService.getUsuarioById(miObjeto.getUsuarios().getId());

        System.out.println("Objeto: " + miObjeto.toString());
        System.out.println("Entrando al update de reserva");
        // if (reservaDB.getDescripcion() == null || reservaDB.getDescripcion().isEmpty() || reservaDB.getDescripcion().isBlank() || reservaDB.getDescripcion() != distrito.getDescripcion()) {
        //     reservaDB.setDescripcion(distrito.getDescripcion());
        // }
        if (reservaDB.getFecha() == null || reservaDB.getFecha() != miObjeto.getFecha()) {
            reservaDB.setFecha(miObjeto.getFecha());
        }
        if (reservaDB.getHora() == null || reservaDB.getHora() != miObjeto.getHora()) {
            reservaDB.setHora(miObjeto.getHora());
        }
        if (reservaDB.getNroPersonas() == null || reservaDB.getNroPersonas() != miObjeto.getNroPersonas()) {
            reservaDB.setNroPersonas(miObjeto.getNroPersonas());
        }
        if (reservaDB.getEstado() == null || reservaDB.getEstado() != miObjeto.getEstado()) {
            reservaDB.setEstado(miObjeto.getEstado());
        }
        if (!reservaDB.getMesas().equals(mesaDB)) {
            reservaDB.setMesas(mesaDB);
        }
        if (!reservaDB.getUsuarios().equals(usuarioDB)) {
            reservaDB.setUsuarios(usuarioDB);
        }
        System.out.println("Reserva actualizada: " + reservaDB.getNroPersonas() + " - " + reservaDB.getId());

        reservaService.updateReserva(reservaDB);
        return ResponseEntity.ok("Actualización exitosa");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }

    @GetMapping("pago/{id}")
    @ResponseBody
    public ResponseEntity<?> pagar(@PathVariable Long id) {
        Reservas reserva = reservaService.getReservaById(id);
        final int[] montoF = {0};
        
        reserva.getPedidos().forEach(pedido -> {
            montoF[0] = montoF[0] + pedido.getPlatos().getPrecio() + pedido.getBebidas().getPrecio();
            System.out.println("Pedido: " + pedido.getId() + " - " + pedido.getPlatos().getNombre() + ":"
                    + pedido.getPlatos().getPrecio() + " - " + pedido.getBebidas().getNombre() + ":"
                    + pedido.getBebidas().getPrecio());
        });
        System.out.println("Monto total: " + montoF[0]);

        DateTimeFormatter formatoEntradaFecha = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // DateTimeFormatter formatoEntradaHora = DateTimeFormatter.ofPattern("hh:mm a");

        // Convierte la fecha String al formato deseado
        LocalDate fecha = LocalDate.parse("06/24/2024", formatoEntradaFecha);
        // LocalTime hora = LocalTime.parse(dato2.toUpperCase(), formatoEntradaHora);

        System.out.println("Fecha formateada: " + fecha);
        // System.out.println("Hora formateada: " + hora);
        Pagos miPago = new Pagos();

        miPago.setMonto(montoF[0]);
        miPago.setFecha(fecha);
        miPago.setHora(null);
        miPago.setTipo("YAPE");
        miPago.setEstado("PENDIENTE");
        miPago.setReservas(reserva);

        pagoService.savePago(miPago);

        return ResponseEntity.ok("Reserva pagada");
    }
}
