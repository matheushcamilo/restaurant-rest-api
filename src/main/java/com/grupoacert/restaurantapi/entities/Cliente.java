package com.grupoacert.restaurantapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpfDoCliente;

    @Column
    private String cepDoCliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pedido> pedidos;
}
