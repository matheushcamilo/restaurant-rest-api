package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Cliente;
import com.grupoacert.restaurantapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping
    public String createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }
}
