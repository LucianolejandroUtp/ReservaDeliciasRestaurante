package com.delicias.reserva.reportes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class ReciboService {
    @Autowired
    ResourceLoader resourceLoader;

    public void generarRecibo(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = "createDato01", required = false) String dato01,
            @RequestParam(name = "createDato20", required = false) Long dato20,
            @RequestParam(name = "createDato21", required = false) Long dato21,
            @RequestParam(name = "createDato22", required = false) Long dato22,
            @RequestParam(name = "createDato23", required = false) Long dato23) {

        try {
            Resource resource = resourceLoader.getResource("classpath:templates/reportes/Simple_Blue_1.jasper");
            // ServletContext context = request.getServletContext();
            // File jasperFile = new
            // File(context.getRealPath("/reportes/Simple_Blue_1.jasper"));
            File jasperFile = resource.getFile();

            System.out.println("Ruta: " + jasperFile);
            // System.out.println("---Conexion: " + conexion.getCatalog());

            Map<String, Object> parametro = new HashMap<>();
            // parametro.put("nn", "nn");
            parametro.put("Parameter1", "3334");
            parametro.put("Nombre", "Lucy");
            parametro.put("NombresCompletos", "nombresCompletos");
            parametro.put("Membresia", "membresia");
            parametro.put("FechaInicio", "12-12-2024");
            parametro.put("FechaFin", "12-12-2014");
            parametro.put("FormaPago", "yape");

            byte[] bytess = JasperRunManager.runReportToPdf(jasperFile.getPath(), parametro, new JREmptyDataSource());

            response.setContentType("application/pdf");

            response.setContentLength(bytess.length);
            // response.setHeader("Content-Disposition", "inline; filename=\"recibo.pdf\"");
            ServletOutputStream output = response.getOutputStream();

            response.getOutputStream();
            output.write(bytess, 0, bytess.length);
            output.flush();
            output.close();
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }

    }
}
