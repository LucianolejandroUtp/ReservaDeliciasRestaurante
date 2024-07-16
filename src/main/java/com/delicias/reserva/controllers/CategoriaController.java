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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.servicios.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = { "/categorias", "/lista" })
    public String getAllCategorias(Model model) {
        List<Categorias> categorias = categoriaService.getAllCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "createDato01", required = false, defaultValue = "Mundo") String createCategoria, Model model) {
        Categorias miCategoria = new Categorias();
        miCategoria.setDescripcion(createCategoria);
        categoriaService.saveCategoria(miCategoria);
        return "redirect:/categoria/lista";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Categorias> obtenerCategoria(@PathVariable Long id) {
        Categorias categoria = categoriaService.getCategoriaById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Categorias miObjeto) {
        Categorias categoriaDB = categoriaService.getCategoriaById(id);

        System.out.println("Objeto: " + miObjeto.toString());
        System.out.println("Entrando al update de categoria");

        if (categoriaDB.getDescripcion() == null || categoriaDB.getDescripcion() != miObjeto.getDescripcion()) {
            categoriaDB.setDescripcion(miObjeto.getDescripcion());
            categoriaService.saveCategoria(categoriaDB);
        }
        return ResponseEntity.ok("Actualización exitosa");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
