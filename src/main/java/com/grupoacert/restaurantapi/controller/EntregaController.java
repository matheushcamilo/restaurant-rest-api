package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    EntregaService entregaService;
    @Autowired
    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @GetMapping
    public List<Entrega> getAllEntregas(){
        return entregaService.getAllEntregas();
    }

    @PostMapping
    public String createEntregas(@RequestBody Entrega entrega){
        return entregaService.createEntrega(entrega);
    }
}
