package com.bacondeveight.estacionamento.domain.terminal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name= "registry_terminal_logs")
@Data
public class RegistryTerminalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "terminal_id", nullable = false)
    private Terminal terminal;

    @Column(nullable = false, updatable = false)
    private Instant horarioEntrada;

    // permitir null enquanto veículo estiver dentro do terminal
    @Column(nullable = true)
    private Instant horarioSaida;

    // novo: referência simples ao motorista e à placa do veículo
    @Column(name = "motorista_id", nullable = false)
    private Long motoristaId;

    @Column(name = "placa", nullable = false)
    private String placa;

}