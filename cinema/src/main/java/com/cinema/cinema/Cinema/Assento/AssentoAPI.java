package com.cinema.cinema.Cinema.Assento;

import com.cinema.cinema.Cinema.Filme.Filme;
import com.cinema.cinema.Cinema.Sessao.Sessao;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Criar depois da service
@RestController
@RequestMapping("/assento")
public class AssentoAPI {
    private final com.cinema.cinema.Cinema.Assento.AssentoService assentoService;

    @Autowired
    public AssentoAPI(com.cinema.cinema.Cinema.Assento.AssentoService assentoService) {
        this.assentoService = assentoService;
    }

    @PostMapping("/cadastrar-assento")
    public ResponseEntity<Assento> cadastrar(@RequestBody Assento assento) {
        return ResponseEntity.ok(this.assentoService.cadastrar(assento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assento> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.assentoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Assento> deletarPorId(@PathVariable Integer id) {
        this.assentoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
