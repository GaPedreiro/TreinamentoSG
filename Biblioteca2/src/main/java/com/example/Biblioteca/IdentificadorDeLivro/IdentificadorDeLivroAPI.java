package com.example.Biblioteca.IdentificadorDeLivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identificador")
public class IdentificadorDeLivroAPI {

    private final com.example.Biblioteca.IdentificadorDeLivro.IdentificadorDeLivroService identificadorDeLivroService;

    @Autowired IdentificadorDeLivroAPI(com.example.Biblioteca.IdentificadorDeLivro.IdentificadorDeLivroService identificadorDeLivroService) {
        this.identificadorDeLivroService = identificadorDeLivroService;
    }

    @PostMapping("")
    public ResponseEntity<IdentificadorDeLivro> cadastrar(@RequestBody IdentificadorDeLivro identificadorDeLivro) {
        return ResponseEntity.ok(this.identificadorDeLivroService.cadastrar(identificadorDeLivro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdentificadorDeLivro> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.identificadorDeLivroService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.identificadorDeLivroService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
