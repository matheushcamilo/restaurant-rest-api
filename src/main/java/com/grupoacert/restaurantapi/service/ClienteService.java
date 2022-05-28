package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Cliente;
import com.grupoacert.restaurantapi.entities.Entrega;
import com.grupoacert.restaurantapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public String criarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return "Cliente de nome " + clienteSalvo.getNome() + " e ID " +
                clienteSalvo.getClienteId() + " foi salvo(a)";


    }

    public Cliente buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Transactional
    public String deletarCliente(String nome) {
        String response;
        try{
            clienteRepository.deleteByNome(nome);
            response = "O cliente de nome " + nome + " foi deletado";
        }catch (Exception e){
            response = e.getMessage();
        }
        return response;
    }
}
