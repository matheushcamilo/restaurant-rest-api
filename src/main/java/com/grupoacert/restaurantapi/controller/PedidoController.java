package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Pedido;
import com.grupoacert.restaurantapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    private List<Pedido> getAllPedidos(){
        return pedidoService.getAllPedidos();
    }

    @PostMapping
    private String createPedido(@RequestBody Pedido pedido){
        return pedidoService.createPedido(pedido);
    }
}
