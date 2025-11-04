package com.bacondeveight.estacionamento.domain.motorista;

import com.bacondeveight.estacionamento.domain.motorista.cartao.DadosCartao;

public record DadosMotorista(Long id, String nome, String telefone, String cnh, DadosCartao cartaoTargetPgto) {
}
