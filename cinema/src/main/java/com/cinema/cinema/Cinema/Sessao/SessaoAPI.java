package com.cinema.cinema.Cinema.Sessao;

import com.cinema.cinema.Cinema.Filme.Filme;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/sessao")
public class SessaoAPI {
    private final com.cinema.cinema.Cinema.Sessao.SessaoService sessaoService;

    @Autowired
    public SessaoAPI(com.cinema.cinema.Cinema.Sessao.SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/cadastrar-sessao")
    public ResponseEntity<Sessao> cadastrar(@RequestBody Sessao sessao) {
        return ResponseEntity.ok(this.sessaoService.cadastrar(sessao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.sessaoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sessao> deletarPorId(@PathVariable Integer id) {
        this.sessaoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
