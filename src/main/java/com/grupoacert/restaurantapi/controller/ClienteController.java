package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Cliente;
import com.grupoacert.restaurantapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("buscar/{nome}")
    public Cliente buscarPorNome(@PathVariable String nome){
        return clienteService.buscarPorNome(nome);
    }

    @PostMapping
    public String criarCliente(@RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }

    @DeleteMapping("deletar/{nome}")
    public String deletarCliente(@PathVariable String nome){
        return clienteService.deletarCliente(nome);
    }
}
