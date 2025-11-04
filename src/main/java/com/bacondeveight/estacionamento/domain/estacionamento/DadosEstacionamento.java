package com.bacondeveight.estacionamento.domain.estacionamento;

import com.bacondeveight.estacionamento.domain.endereco.DadosEndereco;

public record DadosEstacionamento(
        String nome,
        String cnpj,
        DadosEndereco endereco,
        String telefone,
        int moto,
        int carro
){
//    public DadosEstabelecimento(Estabelecimento estabelecimento) {
//        this(estabelecimento.getId(), estabelecimento.getNome(), estabelecimento.getCnpj(), estabelecimento.getEndereco(), estabelecimento.getTelefone(),
//                estabelecimento.getQtdMotos(), estabelecimento.getQtdCarros());
//    }
}
