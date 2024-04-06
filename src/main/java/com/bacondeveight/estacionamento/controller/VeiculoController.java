package com.bacondeveight.estacionamento.controller;

import com.bacondeveight.estacionamento.domain.veiculos.DadosCadastroVeiculo;
import com.bacondeveight.estacionamento.domain.veiculos.Veiculo;
import com.bacondeveight.estacionamento.domain.veiculos.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroVeiculo cadastroDto) {
        var veiculo = new Veiculo(cadastroDto);
        repository.save(veiculo);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listar(){
        var page = repository.findAll();
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DadosCadastroVeiculo> updateProduct(@RequestBody DadosCadastroVeiculo ataulizaProductDto) {
        Veiculo veiculo = repository.getReferenceById(ataulizaProductDto.id());
        veiculo.updateVeiculo(ataulizaProductDto);

        return ResponseEntity.ok(new DadosCadastroVeiculo(veiculo));
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
