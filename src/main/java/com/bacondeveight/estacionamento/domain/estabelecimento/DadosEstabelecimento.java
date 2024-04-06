package com.bacondeveight.estacionamento.domain.estabelecimento;

import com.bacondeveight.estacionamento.domain.endereco.DadosEndereco;
import com.bacondeveight.estacionamento.domain.endereco.Endereco;

public record DadosEstabelecimento(
        Long id,
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
