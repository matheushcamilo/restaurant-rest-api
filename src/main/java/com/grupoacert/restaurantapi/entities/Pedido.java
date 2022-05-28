package com.grupoacert.restaurantapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;
    private String descricaoDoPedido;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Entrega entrega;
}
