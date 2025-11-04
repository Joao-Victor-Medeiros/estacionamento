package com.bacondeveight.estacionamento.domain.estacionamento;

import com.bacondeveight.estacionamento.domain.endereco.Endereco;

public record DetalhamentoEstacionamento(Long id,
                                         String nome,
                                         String cnpj,
                                         Endereco endereco,
                                         String telefone,
                                         Integer qtdMoto,
                                         Integer qtdCarro) {
    public DetalhamentoEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getNome(), estacionamento.getCnpj(), estacionamento.getEndereco(),
                estacionamento.getTelefone(), estacionamento.getQtdVagaMotos(), estacionamento.getQtdVagaCarros());
    }
}
