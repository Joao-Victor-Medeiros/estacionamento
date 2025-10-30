package com.bacondeveight.estacionamento.domain.motorista.cartao;

import org.springframework.data.annotation.Id;

public class Cartao {
    @Id
    private long id;

    private String taget;

    private Tipo tipo;
}