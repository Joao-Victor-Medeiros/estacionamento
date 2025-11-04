package com.bacondeveight.estacionamento.domain.terminal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "terminais")
@Data
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RegistryTerminalLog> logs = new ArrayList<>();

    public void sair() {

    }
    public void entrar() {

    }
}
