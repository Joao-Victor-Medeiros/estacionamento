package com.bacondeveight.estacionamento.domain.motorista.cartao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cartoes")
@Data
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String taget;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}