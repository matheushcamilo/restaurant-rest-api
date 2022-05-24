package com.grupoacert.restaurantapi.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nomeDoCliente;

    private String cpfDoCliente;

    private String cepDoCliente;
}
