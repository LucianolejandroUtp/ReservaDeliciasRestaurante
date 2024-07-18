package com.delicias.reserva.controllers;

import java.math.BigDecimal;
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
import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.servicios.BebidaService;
import com.delicias.reserva.servicios.CategoriaService;

@Controller
@RequestMapping("/bebida")
public class BebidaController {
    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = { "/bebidas", "/lista" })
    public String getAllBebidas(Model model) {
        List<Bebidas> bebidas = bebidaService.getAllBebidas();
        List<Categorias> categorias = categoriaService.getAllCategorias();
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("categorias", categorias);
        return "bebida";
    }

    @PostMapping("/create")
    public String create(
        @RequestParam(name = "createDato01", required = false) String dato01,
            @RequestParam(name = "createDato02", required = false) String dato02,
            @RequestParam(name = "createDato03", required = false) BigDecimal dato03,
            @RequestParam(name = "createDato04", required = false) Integer dato04,
            @RequestParam(name = "createDato05", required = false) Integer dato05,
            @RequestParam(name = "createDato06", required = false) String dato06,
            @RequestParam(name = "createDato07", required = false) String dato07,
            @RequestParam(name = "createDato08", required = false) String dato08,
            @RequestParam(name = "createDato09", required = false) String dato09,
            @RequestParam(name = "createDato10", required = false) Long dato10
    ) {
        Categorias miCategoria = categoriaService.getCategoriaById(dato10);

        Bebidas miBebida = new Bebidas();
        miBebida.setNombre(dato01);
        miBebida.setDescripcion(dato02);
        miBebida.setPrecio(dato03);
        miBebida.setStock(dato04);
        miBebida.setCategorias(miCategoria);
        bebidaService.saveBebida(miBebida);
        return "redirect:/bebida/lista";
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id){
        bebidaService.deleteBebida(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
