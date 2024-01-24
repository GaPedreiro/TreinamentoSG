package com.example.Hospital.LogInternacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/logInternacoes")
public class LogInternacoesAPI {
    private final com.example.Hospital.LogInternacoes.LogInternacoesService logInternacoesService;

    @Autowired
    public LogInternacoesAPI(com.example.Hospital.LogInternacoes.LogInternacoesService logInternacoesService) {
        this.logInternacoesService = logInternacoesService;
    }

    @PostMapping("")
    public ResponseEntity<LogInternacoes> cadastrar(@RequestBody LogInternacoes logInternacoes) {
        return ResponseEntity.ok(this.logInternacoesService.cadastrar(logInternacoes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogInternacoes> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.logInternacoesService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.logInternacoesService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}