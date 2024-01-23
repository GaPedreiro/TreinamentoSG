package com.example.Biblioteca.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/livro")
public class LivroAPI {

    private final com.example.Biblioteca.Livro.LivroService livroService;

    @Autowired
    public LivroAPI(com.example.Biblioteca.Livro.LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("")
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        return ResponseEntity.ok(this.livroService.cadastrar(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.livroService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.livroService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Livro>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.livroService.findByNome(nome));
    }

    @GetMapping("/orddem-alfabetica")
    public
}
