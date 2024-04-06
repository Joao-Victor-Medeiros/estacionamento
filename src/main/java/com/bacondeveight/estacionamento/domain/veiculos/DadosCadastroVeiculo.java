package com.bacondeveight.estacionamento.domain.veiculos;

public record DadosCadastroVeiculo(Long id, String marca, String modelo, String cor, String placa, Tipo tipo) {
    public DadosCadastroVeiculo(Veiculo veiculo) {
        this(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getPlaca(), veiculo.getTipo());
    }
}
