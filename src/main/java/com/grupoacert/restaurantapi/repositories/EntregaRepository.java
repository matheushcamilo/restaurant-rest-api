package com.grupoacert.restaurantapi.repositories;

import com.grupoacert.restaurantapi.entities.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
