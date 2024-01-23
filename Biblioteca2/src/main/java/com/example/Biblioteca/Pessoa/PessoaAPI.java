package com.example.Biblioteca.Pessoa;

import com.example.Biblioteca.Livro.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaAPI {

    private final com.example.Biblioteca.Pessoa.PessoaService pessoaService;

    @Autowired
    public PessoaAPI(com.example.Biblioteca.Pessoa.PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(this.pessoaService.cadastrar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pessoaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.pessoaService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
