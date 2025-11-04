package com.bacondeveight.estacionamento.controller;

import com.bacondeveight.estacionamento.domain.motorista.DadosMotorista;
import com.bacondeveight.estacionamento.domain.motorista.Motorista;
import com.bacondeveight.estacionamento.domain.motorista.MotoristaRepository;
import com.bacondeveight.estacionamento.domain.motorista.cartao.DadosCartao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {
    @Autowired
    private MotoristaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Motorista> cadastrar(@RequestBody DadosMotorista cadastroDto) {
        var motorista = new Motorista(cadastroDto);
        repository.save(motorista);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> listar(){
        var lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosMotorista> detalhar(@PathVariable Long id){
        var opt = repository.findById(id);
        if(opt.isPresent()) {
            var m = opt.get();
            var c = m.getCartaoTargetPgto();
            DadosCartao dc = null;
            if (c != null) dc = new DadosCartao(c.getId(), c.getTaget(), c.getTipo());
            return ResponseEntity.ok(new DadosMotorista(m.getId(), m.getNome(), m.getTelefone(), m.getCnh(), dc));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosMotorista> atualizar(@RequestBody DadosMotorista atualizaDto) {
        Motorista motorista = repository.getReferenceById(atualizaDto.id());
        motorista.updateMotorista(atualizaDto);

        var c = motorista.getCartaoTargetPgto();
        DadosCartao dc = null;
        if (c != null) dc = new DadosCartao(c.getId(), c.getTaget(), c.getTipo());

        return ResponseEntity.ok(new DadosMotorista(motorista.getId(), motorista.getNome(), motorista.getTelefone(), motorista.getCnh(), dc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) throws Exception {
        if(repository.existsById(id)){
            this.repository.deleteById(id);
        }else {
            throw new Exception("id do motorista não encontrado");
        }

        return ResponseEntity.noContent().build();
    }
}
