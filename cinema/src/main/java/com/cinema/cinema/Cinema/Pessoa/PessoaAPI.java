package com.cinema.cinema.Cinema.Pessoa;
import com.cinema.cinema.Cinema.Filme.Filme;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/pessoa")
public class PessoaAPI {
    private final com.cinema.cinema.Cinema.Pessoa.PessoaService pessoaService;

    @Autowired
    public PessoaAPI(com.cinema.cinema.Cinema.Pessoa.PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/cadastrar-pessoa")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(this.pessoaService.cadastrar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pessoaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletarPorId(@PathVariable Integer id) {
        this.pessoaService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
