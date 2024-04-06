package com.bacondeveight.estacionamento.domain.estabelecimento;

import com.bacondeveight.estacionamento.domain.endereco.DadosEndereco;
import com.bacondeveight.estacionamento.domain.endereco.Endereco;

public record DetalhamentoEstacionamento(Long id,
                                         String nome,
                                         String cnpj,
                                         Endereco endereco,
                                         String telefone,
                                         Integer qtdMoto,
                                         Integer qtdCarro) {
    public DetalhamentoEstacionamento(Estabelecimento estabelecimento) {
        this(estabelecimento.getId(), estabelecimento.getNome(), estabelecimento.getCnpj(), estabelecimento.getEndereco(),
                estabelecimento.getTelefone(), estabelecimento.getQtdMotos(), estabelecimento.getQtdCarros());
    }
}
