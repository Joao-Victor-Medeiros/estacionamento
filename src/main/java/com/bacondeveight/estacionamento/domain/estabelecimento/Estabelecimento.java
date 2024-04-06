package com.bacondeveight.estacionamento.domain.estabelecimento;

import com.bacondeveight.estacionamento.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estabelecimentos")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private int qtdMotos;
    private int qtdCarros;

    public Estabelecimento(DadosEstabelecimento estabelecimentoDto) {
        this.nome = estabelecimentoDto.nome();
        this.cnpj = estabelecimentoDto.cnpj();
        this.endereco = new Endereco(estabelecimentoDto.endereco());
        this.telefone = estabelecimentoDto.telefone();
        this.qtdMotos = estabelecimentoDto.moto();
        this.qtdCarros = estabelecimentoDto.carro();
    }

    public void atualizaEstabelecimento(DadosAtualizaEstabelecimento estabelecimento) {
        if(estabelecimento.id() != null) {
            this.nome = estabelecimento.nome();
            this.cnpj = estabelecimento.cnpj();
            this.endereco = estabelecimento.endereco();
            this.telefone = estabelecimento.telefone();
            this.qtdMotos = estabelecimento.qtdMoto();
            this.qtdCarros = estabelecimento.qtdCarro();
        }
    }
}