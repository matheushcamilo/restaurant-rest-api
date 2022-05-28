package com.grupoacert.restaurantapi.repositories;

import com.grupoacert.restaurantapi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);

    @Modifying
    @Query("delete from Cliente c where c.nome=?1")
    void deleteByNome(String nome);
}
