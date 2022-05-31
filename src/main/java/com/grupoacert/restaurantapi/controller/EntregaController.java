package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    EntregaService entregaService;
    @Autowired
    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @GetMapping
    public List<Entrega> listarEntregas(){
        return entregaService.listarEntregas();
    }

    @GetMapping("buscar/{id}")
    public Optional<Entrega> buscarEntrega(@PathVariable Long id){
        return entregaService.buscarEntrega(id);
    }

    @PostMapping
    public String criarEntrega(@RequestBody Entrega entrega){
        return entregaService.criarEntrega(entrega);
    }

    @DeleteMapping("deletar/{id}")
    public String deletarEntrega(@PathVariable Long id){
        return entregaService.deletarEntrega(id);
    }
}
