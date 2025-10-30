package com.bacondeveight.estacionamento.domain.motorista;

import com.bacondeveight.estacionamento.domain.motorista.cartao.Cartao;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Motorista {
    @Id
    private long id;
    private String nome;
    private String telefone;
    private String cnh;
    private Cartao cartaoTargetPgto;
}
