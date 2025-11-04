package com.bacondeveight.estacionamento.controller;

import com.bacondeveight.estacionamento.domain.motorista.cartao.Cartao;
import com.bacondeveight.estacionamento.domain.motorista.cartao.CartaoRepository;
import com.bacondeveight.estacionamento.domain.motorista.cartao.DadosCartao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Cartao> cadastrar(@RequestBody DadosCartao cadastroDto) {
        var cartao = new Cartao();
        cartao.setTaget(cadastroDto.taget());
        cartao.setTipo(cadastroDto.tipo());
        repository.save(cartao);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listar(){
        var lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosCartao> detalhar(@PathVariable Long id){
        var opt = repository.findById(id);
        if(opt.isPresent()){
            var c = opt.get();
            return ResponseEntity.ok(new DadosCartao(c.getId(), c.getTaget(), c.getTipo()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosCartao> atualizar(@RequestBody DadosCartao atualizaDto) {
        var cartao = repository.getReferenceById(atualizaDto.id());
        cartao.setTaget(atualizaDto.taget());
        cartao.setTipo(atualizaDto.tipo());

        return ResponseEntity.ok(new DadosCartao(cartao.getId(), cartao.getTaget(), cartao.getTipo()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) throws Exception {
        if(repository.existsById(id)){
            this.repository.deleteById(id);
        }else {
            throw new Exception("id do cartão não encontrado");
        }

        return ResponseEntity.noContent().build();
    }
}
