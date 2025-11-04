package com.bacondeveight.estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("terminal")
public class EstacionamentoController {
    @PostMapping
    public ResponseEntity verificaCartao() {
        //criar logica de entrar pegar o horario final menos o inicial evou ter um intervalo de tempo, calcular o valor por hora
        return ResponseEntity.ok("terminal inicializado");
    }

//    @PatchMapping
//    public ResponseEntity entraVeiculo() {
//        return ResponseEntity.ok("veículo autorizado");
//    }
//
//    @PatchMapping
//    public ResponseEntity saiVeiculo() {
//        return ResponseEntity.ok("volte smepre!");
//    }
}
