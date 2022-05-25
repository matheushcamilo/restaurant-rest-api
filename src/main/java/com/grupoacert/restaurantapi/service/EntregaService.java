package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.repositories.EntregaRepository;
import com.grupoacert.restaurantapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    EntregaRepository entregaRepository;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<Entrega> getAllEntregas(){
        return entregaRepository.findAll();
    }

    public String createEntrega(Entrega entrega){
        Entrega entregaSalva = entregaRepository.save(entrega);
        return "Entrega de Id " + entregaSalva.getEntregaId() + " registrada com sucesso";
    }
}
