package com.bacondeveight.estacionamento.domain.estacionamento;

import com.bacondeveight.estacionamento.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estacionamentos")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private int qtdVagaMotos;
    private int qtdVagaCarros;

    public Estacionamento(DadosEstacionamento estacionamentoDto) {
        this.nome = estacionamentoDto.nome();
        this.cnpj = estacionamentoDto.cnpj();
        this.endereco = new Endereco(estacionamentoDto.endereco());
        this.telefone = estacionamentoDto.telefone();
        this.qtdVagaMotos = estacionamentoDto.moto();
        this.qtdVagaCarros = estacionamentoDto.carro();
    }

    public void atualizaEstacionamento(DadosAtualizaEstacionamento estacionamento) {
        if(estacionamento.id() != null) {
            this.nome = estacionamento.nome();
            this.cnpj = estacionamento.cnpj();
            this.endereco = estacionamento.endereco();
            this.telefone = estacionamento.telefone();
            this.qtdVagaMotos = estacionamento.qtdMoto();
            this.qtdVagaCarros = estacionamento.qtdCarro();
        }
    }
}