package com.example.Mecanica.Peca;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peca")
public class PecaAPI {

    private final com.example.Mecanica.Peca.PecaService pecaService;

    @Autowired
    public PecaAPI(com.example.Mecanica.Peca.PecaService pecaService) {
        this.pecaService = pecaService;
    }

    @PostMapping("")
    public ResponseEntity<Peca> cadastrar(@RequestBody Peca peca) {
        return ResponseEntity.ok(this.pecaService.cadastrar(peca));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pecaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.pecaService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
