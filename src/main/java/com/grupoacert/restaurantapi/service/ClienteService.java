package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Cliente;
import com.grupoacert.restaurantapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public String createCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return "Cliente de nome " + clienteSalvo.getNomeDoCliente() + " e ID " +
                clienteSalvo.getClienteId() + " foi salvo(a)";


    }
}
