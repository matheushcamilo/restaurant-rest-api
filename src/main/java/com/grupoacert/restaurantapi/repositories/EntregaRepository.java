package com.grupoacert.restaurantapi.repositories;

import com.grupoacert.restaurantapi.entities.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
