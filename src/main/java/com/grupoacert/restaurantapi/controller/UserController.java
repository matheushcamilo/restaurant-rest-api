package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Usuario;
import com.grupoacert.restaurantapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services/controller/user")
public class UserController {

    UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public String salvarNovoUser(@RequestBody Usuario usuario){
        return usuarioService.salvarNovoUser(usuario);
    }
}
