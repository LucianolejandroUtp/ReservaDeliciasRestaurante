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

import com.delicias.reserva.modelos.Distritos;
import com.delicias.reserva.modelos.Roles;
import com.delicias.reserva.modelos.Usuarios;
import com.delicias.reserva.servicios.DistritoService;
import com.delicias.reserva.servicios.RolService;
import com.delicias.reserva.servicios.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DistritoService distritoService;
    
    @Autowired
    private RolService rolService;

    @GetMapping(path = { "/usuarios", "/lista" })
    public String getAllUsuarios(Model model) {
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();
        List<Distritos> distritos = distritoService.getAllDistritos();
        List<Roles> roles = rolService.getAllRoles();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("distritos", distritos);
        model.addAttribute("roles", roles);
        return "usuario";
    }

    @PostMapping("/create")
    public String create(
        @RequestParam(name = "createDato01", required = false) String dato01,
            @RequestParam(name = "createDato02", required = false) String dato02,
            @RequestParam(name = "createDato03", required = false) String dato03,
            @RequestParam(name = "createDato04", required = false) String dato04,
            @RequestParam(name = "createDato05", required = false) String dato05,
            @RequestParam(name = "createDato06", required = false) String dato06,
            @RequestParam(name = "createDato07", required = false) String dato07,
            @RequestParam(name = "createDato08", required = false) String dato08,
            @RequestParam(name = "createDato09", required = false) String dato09,
            @RequestParam(name = "createDato10", required = false) Long dato10,
            @RequestParam(name = "createDato11", required = false) Long dato11
    ){
        Distritos miDistrito = distritoService.getDistritoById(dato10);
        Roles miRol = rolService.getRolById(dato11);

        Usuarios miUsuario = new Usuarios();
        miUsuario.setNombres(dato01);
        miUsuario.setApellidoPat(dato02);
        miUsuario.setApellidoMat(dato03);
        miUsuario.setTelefono(dato04);
        miUsuario.setDireccion(dato05);
        miUsuario.setReferencia(dato06);
        miUsuario.setDni(dato07);
        miUsuario.setEmail(dato08);
        miUsuario.setPassword(dato09);

        miUsuario.setDistritos(miDistrito);
        miUsuario.setRoles(miRol);
        return "redirect:/usuario/usuarios";

    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete (@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
