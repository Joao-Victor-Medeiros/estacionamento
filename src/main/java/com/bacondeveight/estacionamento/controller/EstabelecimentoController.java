package com.bacondeveight.estacionamento.controller;

import com.bacondeveight.estacionamento.domain.estabelecimento.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosEstabelecimento cadastroDto) {
        var estabelecimento = new Estabelecimento(cadastroDto);
        repository.save(estabelecimento);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listar(){
        var page = repository.findAll();
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DetalhamentoEstacionamento> updateProduct(@RequestBody DadosAtualizaEstabelecimento estabelecimentoDto) {
        Estabelecimento estabelecimento = repository.getReferenceById(estabelecimentoDto.id());
        estabelecimento.atualizaEstabelecimento(estabelecimentoDto);

        return ResponseEntity.ok(new DetalhamentoEstacionamento(estabelecimento));
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
