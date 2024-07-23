package com.delicias.reserva.reportes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delicias.reserva.modelos.Reservas;
import com.delicias.reserva.servicios.ReservaService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/recibo")
public class ReciboController {
    @Autowired
    ResourceLoader resourceLoader;
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/create/{id}")
    public String create(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        Reservas miReserva = reservaService.getReservaById(id);
        final int[] montoF = { 0 };
        String dni = miReserva.getUsuarios().getDni();
        String nombresCompletos = miReserva.getUsuarios().getApellidoPat() + ", " + miReserva.getUsuarios().getNombres();
        String fecha = miReserva.getFecha().toString();

        miReserva.getPedidos().forEach(pedido -> {
            montoF[0] = montoF[0] + pedido.getPlatos().getPrecio() + pedido.getBebidas().getPrecio();
            System.out.println("Pedido: " + pedido.getId() + " - " + pedido.getPlatos().getNombre() + ":"
                    + pedido.getPlatos().getPrecio() + " - " + pedido.getBebidas().getNombre() + ":"
                    + pedido.getBebidas().getPrecio());
        });
        System.out.println("Monto total: " + montoF[0]);

        try {
            Resource resource = resourceLoader.getResource("classpath:templates/reportes/Simple_Blue_1.jasper");
            // ServletContext context = request.getServletContext();
            // File jasperFile = new File(context.getRealPath("/reportes/Simple_Blue_1.jasper"));
            File jasperFile = resource.getFile();

            System.out.println("Ruta: " + jasperFile);
            // System.out.println("---Conexion: " + conexion.getCatalog());

            Map<String, Object> parametro = new HashMap<>();
            // parametro.put("nn", "nn");
            parametro.put("Parameter1", "3334");
            parametro.put("Nombre",  dni);
            parametro.put("NombresCompletos", nombresCompletos);
            parametro.put("Membresia", String.valueOf(montoF[0]));
            parametro.put("FechaInicio", fecha);
            parametro.put("FechaFin", "12-12-2014");
            parametro.put("FormaPago", "yape");

            byte[] bytess = JasperRunManager.runReportToPdf(jasperFile.getPath(), parametro, new JREmptyDataSource());

            response.setContentType("application/pdf");

            response.setContentLength(bytess.length);

            ServletOutputStream output = response.getOutputStream();

            response.getOutputStream();
            output.write(bytess, 0, bytess.length);
            output.flush();
            output.close();
        } catch (JRException | IOException e) {
            System.out.println(e);
        }
        return "redirect:/pedido/pedidos";
    }
}
