package com.example.Mecanica.Servico;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoAPI {
    private final com.example.Mecanica.Servico.ServicoService servicoService;

    @Autowired
    public ServicoAPI(com.example.Mecanica.Servico.ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping("")
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico) {
        return ResponseEntity.ok(this.servicoService.cadastrar(servico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.servicoService.pegarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.servicoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
