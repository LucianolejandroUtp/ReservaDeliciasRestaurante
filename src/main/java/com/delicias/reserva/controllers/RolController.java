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

import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.servicios.RolService;


@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping(path = {"/roles", "/lista"})
    public String getAllRoles(Model model) {
        List<Roles> roles = rolService.getAllRoles();
        model.addAttribute("roles", roles);
        return "rol";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name ="createDato01", required = false, defaultValue = "Mundo") String createRol, Model model) {
        Roles miRol = new Roles();
        miRol.setDescripcion(createRol);
        rolService.saveRol(miRol);
        return "redirect:/rol/lista";
    }



    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
