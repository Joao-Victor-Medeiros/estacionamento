package com.bacondeveight.estacionamento.controller;

import com.bacondeveight.estacionamento.domain.estacionamento.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
    @Autowired
    private EstacionamentoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<Estacionamento> cadastrar(@RequestBody DadosEstacionamento cadastroDto) {
        var estabelecimento = new Estacionamento(cadastroDto);
        repository.save(estabelecimento);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Estacionamento>> listar(){
        var page = repository.findAll();
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DetalhamentoEstacionamento> updateProduct(@RequestBody DadosAtualizaEstacionamento estabelecimentoDto) {
        Estacionamento estacionamento = repository.getReferenceById(estabelecimentoDto.id());
        estacionamento.atualizaEstacionamento(estabelecimentoDto);

        return ResponseEntity.ok(new DetalhamentoEstacionamento(estacionamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) throws Exception {
        if(repository.existsById(id)){
            this.repository.deleteById(id);
        }else {
            throw new Exception("id do produto não encontrado");
        }

        return ResponseEntity.noContent().build();
    }
}
