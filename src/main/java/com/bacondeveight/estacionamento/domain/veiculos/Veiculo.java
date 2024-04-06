package com.bacondeveight.estacionamento.domain.veiculos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="veiculos")
@Entity
@Data
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    @Enumerated
    private Tipo tipo;

    public Veiculo(DadosCadastroVeiculo veiculoDto) {
        this.marca = veiculoDto.marca();
        this.modelo = veiculoDto.modelo();
        this.cor = veiculoDto.cor();
        this.placa = veiculoDto.placa();
        this.tipo = veiculoDto.tipo();
    }

    public void updateVeiculo(DadosCadastroVeiculo veiculoDto) {
        if(veiculoDto.id() != null) {
            this.marca = veiculoDto.marca();
            this.modelo = veiculoDto.modelo();
            this.cor = veiculoDto.cor();
            this.placa = veiculoDto.placa();
            this.tipo = veiculoDto.tipo();
        }
    }
}
