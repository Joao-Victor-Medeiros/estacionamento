package com.bacondeveight.estacionamento.domain.estacionamento;

import com.bacondeveight.estacionamento.domain.endereco.Endereco;

public record DadosAtualizaEstacionamento(Long id, String nome,
                                          String cnpj,
                                          Endereco endereco,
                                          String telefone,
                                          int qtdMoto,
                                          int qtdCarro) {
}
