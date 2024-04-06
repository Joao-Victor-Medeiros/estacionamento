package com.bacondeveight.estacionamento.domain.estabelecimento;

import com.bacondeveight.estacionamento.domain.endereco.Endereco;

public record DadosAtualizaEstabelecimento(Long id, String nome,
                                           String cnpj,
                                           Endereco endereco,
                                           String telefone,
                                           int qtdMoto,
                                           int qtdCarro) {
}
