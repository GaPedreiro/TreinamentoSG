package com.cinema.cinema.Cinema.Filme;

import com.cinema.cinema.Cinema.Filme.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/filme")
public class FilmeAPI {
    private final com.cinema.cinema.Cinema.Filme.FilmeService filmeService;

    @Autowired
    public FilmeAPI(com.cinema.cinema.Cinema.Filme.FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("")
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        return ResponseEntity.ok(this.filmeService.cadastrar(filme));
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme) {
        return ResponseEntity.ok(this.filmeService.atualizar(filme));
    }

     */

    @GetMapping("/{id}")
    public ResponseEntity<Filme> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.filmeService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.filmeService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Filme>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.filmeService.findByNome(nome));
    }
}
