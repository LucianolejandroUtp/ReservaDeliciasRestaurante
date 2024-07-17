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

import com.delicias.reserva.modelos.Mesas;
import com.delicias.reserva.servicios.MesaService;

@Controller
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping(path = { "/mesas", "/lista" })
    public String getAllMesas(Model model) {
        List<Mesas> mesas = mesaService.getAllMesas();
        model.addAttribute("mesas", mesas);
        return "mesa";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam(name = "createDato01", required = false) Integer dato01,
            @RequestParam(name = "createDato02", required = false) Integer dato02,
            @RequestParam(name = "createDato03", required = false) String dato03) {
        Mesas miMesa = new Mesas();
        miMesa.setNroMesa(dato01);
        miMesa.setCapacidad(dato02);
        miMesa.setDisponibilidad(dato03);
        mesaService.saveMesa(miMesa);
        return "redirect:/mesa/lista";
    }

    //Método para obtener los datos de una mesa por su id (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Mesas> getMesaById(@PathVariable Long id) {
        Mesas mesa = mesaService.getMesaById(id);
        return ResponseEntity.ok(mesa);
    }

    //Método para actualizar los datos de una mesa
    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Mesas miObjeto){
        Mesas mesaDB = mesaService.getMesaById(id);

        if(mesaDB.getNroMesa() == null || mesaDB.getNroMesa() != miObjeto.getNroMesa()){
            mesaDB.setNroMesa(miObjeto.getNroMesa());
        }
        if(mesaDB.getCapacidad() == null || mesaDB.getCapacidad() != miObjeto.getCapacidad()){
            mesaDB.setCapacidad(miObjeto.getCapacidad());
        }
        if(mesaDB.getDisponibilidad() == null || mesaDB.getDisponibilidad() != miObjeto.getDisponibilidad()){
            mesaDB.setDisponibilidad(miObjeto.getDisponibilidad());
        }
        if (mesaDB.getEstado() == null || mesaDB.getEstado() != miObjeto.getEstado()) {
            mesaDB.setEstado(miObjeto.getEstado());
        }

        mesaService.updateMesa(mesaDB);
        return ResponseEntity.ok("Actualización exitosa");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        mesaService.deleteMesa(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
