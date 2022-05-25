package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Pedido;
import com.grupoacert.restaurantapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService {

    PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public String createPedido(Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return "O pedido de Id " + pedidoSalvo.getPedidoId() + " foi salvo com sucesso";
    }
}
