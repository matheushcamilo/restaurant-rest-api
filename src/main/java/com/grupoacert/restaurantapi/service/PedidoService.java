package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Pedido;
import com.grupoacert.restaurantapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public String criarPedido(Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return "O pedido de Id " + pedidoSalvo.getPedidoId() + " foi salvo com sucesso";
    }

    public Optional<Pedido> buscarPedido(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public String deletarPedido(Long id) {
        String response;
        try {
            pedidoRepository.deleteById(id);
            response = "Pedido de Id " + id + " foi deletado!";
        }catch (Exception e){
            response = "Algo deu errado";
        }
        return response;
    }
}
