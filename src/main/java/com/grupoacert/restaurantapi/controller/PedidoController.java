package com.grupoacert.restaurantapi.controller;

import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.entities.Pedido;
import com.grupoacert.restaurantapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    private List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @GetMapping("buscar/{id}")
    public Optional<Pedido> buscarPedido(@PathVariable Long id){
        return pedidoService.buscarPedido(id);
    }

    @PostMapping
    private String criarPedido(@RequestBody Pedido pedido){
        return pedidoService.criarPedido(pedido);
    }

    @Transactional
    @DeleteMapping("deletar/{id}")
    public String deletarPedido(@PathVariable Long id){
        return pedidoService.deletarPedido(id);
    }
}
