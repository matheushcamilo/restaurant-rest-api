package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.repositories.EntregaRepository;
import com.grupoacert.restaurantapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {
    EntregaRepository entregaRepository;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<Entrega> listarEntregas(){
        return entregaRepository.findAll();
    }

    public String criarEntrega(Entrega entrega){
        Entrega entregaSalva = entregaRepository.save(entrega);
        return "Entrega de Id " + entregaSalva.getEntregaId() + " registrada com sucesso";
    }

    public Optional<Entrega> buscarEntrega(Long id) {
        return entregaRepository.findById(id);
    }

    @Transactional
    public String deletarEntrega(Long id) {
        String response;
        try {
            entregaRepository.deleteById(id);
            response = "Entrega de Id " + id + " foi deletada!";
        }catch (Exception e){
            response = "Algo deu errado";
        }
        return response;
    }
}
