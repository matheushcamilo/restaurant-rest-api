package com.grupoacert.restaurantapi.repositories;

import com.grupoacert.restaurantapi.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
