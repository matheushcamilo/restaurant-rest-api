package com.grupoacert.restaurantapi.service;

import com.grupoacert.restaurantapi.entities.Usuario;
import com.grupoacert.restaurantapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional(rollbackOn = Exception.class)
    public String salvarNovoUser(Usuario usuario) {
        try{
            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
            Usuario usuarioSalvo = usuarioRepository.save(usuario);
            return "O token gerado para este usuário é: ";
        }catch (Exception e){
            return "Error: " + e.getMessage();
        }

    }

    public Usuario findUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
