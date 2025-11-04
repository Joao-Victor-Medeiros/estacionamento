package com.bacondeveight.estacionamento.domain.motorista;

import com.bacondeveight.estacionamento.domain.motorista.cartao.Cartao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "motoristas")
@Entity
@Data
@NoArgsConstructor
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String telefone;
    private String cnh;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cartao_id")
    private Cartao cartaoTargetPgto;

    public Motorista(DadosMotorista dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.cnh = dto.cnh();
        var d = dto.cartaoTargetPgto();
        if (d != null) {
            this.cartaoTargetPgto = new Cartao();
            this.cartaoTargetPgto.setTaget(d.taget());
            this.cartaoTargetPgto.setTipo(d.tipo());
        }
    }

    public void updateMotorista(DadosMotorista dto) {
        if (dto.id() != null) {
            this.nome = dto.nome();
            this.telefone = dto.telefone();
            this.cnh = dto.cnh();
            var d = dto.cartaoTargetPgto();
            if (d != null) {
                if (this.cartaoTargetPgto == null) this.cartaoTargetPgto = new Cartao();
                this.cartaoTargetPgto.setTaget(d.taget());
                this.cartaoTargetPgto.setTipo(d.tipo());
            }
        }
    }
}
