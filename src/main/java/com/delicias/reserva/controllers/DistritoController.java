package com.delicias.reserva.controllers;

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.servicios.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/prueba")
    public String prueba(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre, Model model) {
        System.out.println("Hola mundo");
        model.addAttribute("nombre", nombre);
        return "prueba";
    }

    @GetMapping(path = {"/distritos", "/lista"})
    public String getAllDistritos(Model model) {

        List<Distritos> distritos = distritoService.getAllDistritos();

//        Distrito dis = distritoService.getDistritoById(3L);

//        for (Distrito distrito : distritos) {
//            System.out.println(distrito.toString());
//        }
//        System.out.println("--" + dis.getDescripcion() + "--");
        model.addAttribute("distritos", distritos);

        return "distrito";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name ="createDistrito", required = false, defaultValue = "Mundo") String createDistrito, Model model) {

        System.out.println("---" + createDistrito + "---");
        Distritos miDistrito = new Distritos();

        miDistrito.setDescripcion(createDistrito);

        distritoService.saveDistrito(miDistrito);

        return "redirect:/distrito/lista";
    }

    // Método para obtener los datos de un distrito por ID (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Distritos> obtenerDistrito(@PathVariable Long id) {
        Distritos distrito = distritoService.getDistritoById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Distrito inválido Id:" + id));
        return ResponseEntity.ok(distrito); // Devolver los datos del distrito en formato JSON
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Distritos distrito) {
        Distritos distritoDB = distritoService.getDistritoById(id);

        System.out.println("Entrando al update de distrito");
        if (distritoDB.getDescripcion() == null || distritoDB.getDescripcion().isEmpty() || distritoDB.getDescripcion().isBlank() || distritoDB.getDescripcion() != distrito.getDescripcion()) {
            distritoDB.setDescripcion(distrito.getDescripcion());
        }

        if (distritoDB.getEstado() == null || distritoDB.getEstado() != distrito.getEstado()) {
            distritoDB.setEstado(distrito.getEstado());
        }

        System.out.println("Distrito actualizado: " + distritoDB.getDescripcion() + " - " + distritoDB.getId());


        distritoService.updateDistrito(distritoDB);

        return ResponseEntity.ok("Actualización exitosa");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        distritoService.deleteDistrito(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
