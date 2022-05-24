package com.grupoacert.restaurantapi.repositories;

import com.grupoacert.restaurantapi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
