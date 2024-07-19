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

        usuarioService.saveUsuario(miUsuario);
        return "redirect:/usuario/usuarios";
    }

    //Método para obtener los datos de un plato por ID (para el modal de edición)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id){
        Usuarios usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Usuarios miObjeto){
        Usuarios usuarioDB = usuarioService.getUsuarioById(id);
        Distritos distritoDB = distritoService.getDistritoById(miObjeto.getDistritos().getId());
        Roles rolDB = rolService.getRolById(miObjeto.getRoles().getId());

        if (usuarioDB.getNombres() == null || usuarioDB.getNombres().isEmpty() || usuarioDB.getNombres() != miObjeto.getNombres()){
            usuarioDB.setNombres(miObjeto.getNombres());
        }
        if (usuarioDB.getApellidoPat() == null || usuarioDB.getApellidoPat().isEmpty() || usuarioDB.getApellidoPat() != miObjeto.getApellidoPat()){
            usuarioDB.setApellidoPat(miObjeto.getApellidoPat());
        }
        if (usuarioDB.getApellidoMat() == null || usuarioDB.getApellidoMat().isEmpty() || usuarioDB.getApellidoMat() != miObjeto.getApellidoMat()){
            usuarioDB.setApellidoMat(miObjeto.getApellidoMat());
        }
        if (usuarioDB.getTelefono() == null || usuarioDB.getTelefono().isEmpty() || usuarioDB.getTelefono() != miObjeto.getTelefono()){
            usuarioDB.setTelefono(miObjeto.getTelefono());
        }
        if (usuarioDB.getDireccion() == null || usuarioDB.getDireccion().isEmpty() || usuarioDB.getDireccion() != miObjeto.getDireccion()){
            usuarioDB.setDireccion(miObjeto.getDireccion());
        }
        if (usuarioDB.getReferencia() == null || usuarioDB.getReferencia().isEmpty() || usuarioDB.getReferencia() != miObjeto.getReferencia()){
            usuarioDB.setReferencia(miObjeto.getReferencia());
        }
        if (usuarioDB.getDni() == null || usuarioDB.getDni().isEmpty() || usuarioDB.getDni() != miObjeto.getDni()){
            usuarioDB.setDni(miObjeto.getDni());
        }
        if (usuarioDB.getEmail() == null || usuarioDB.getEmail().isEmpty() || usuarioDB.getEmail() != miObjeto.getEmail()){
            usuarioDB.setEmail(miObjeto.getEmail());
        }
        if (usuarioDB.getPassword() == null || usuarioDB.getPassword().isEmpty() || usuarioDB.getPassword() != miObjeto.getPassword()){
            usuarioDB.setPassword(miObjeto.getPassword());
        }
        if (usuarioDB.getEstado() == null || usuarioDB.getEstado().isEmpty() || usuarioDB.getEstado() != miObjeto.getEstado()){
            usuarioDB.setEstado(miObjeto.getEstado());
        }
        if (!usuarioDB.getDistritos().equals(distritoDB)){
            usuarioDB.setDistritos(distritoDB);
        }
        if (!usuarioDB.getRoles().equals(rolDB)){
            usuarioDB.setRoles(rolDB);
        }

        usuarioService.saveUsuario(usuarioDB);
        
        return ResponseEntity.ok("Actualización exitosa");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete (@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }
}
