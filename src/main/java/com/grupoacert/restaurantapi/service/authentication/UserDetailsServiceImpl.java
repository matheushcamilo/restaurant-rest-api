package com.grupoacert.restaurantapi.service.authentication;

import com.grupoacert.restaurantapi.entities.Usuario;
import com.grupoacert.restaurantapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioService usuarioService;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        username = username.toLowerCase();
        Usuario usuario;
        try {
            usuario = usuarioService.findUserByUsername(username);
        }catch (ObjectRetrievalFailureException orfe){
            throw new UsernameNotFoundException("Usuário '" + username
                    + "' não foi encontrado");
        }

        UserDetails userDetails = org.springframework.security.
                core.userdetails.User.withUsername(username).
                password(usuario.getPassword()).authorities("USER").build();
        return userDetails;
    }
}
