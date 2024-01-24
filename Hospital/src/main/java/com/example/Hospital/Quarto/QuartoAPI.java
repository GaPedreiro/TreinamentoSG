package com.example.Hospital.Quarto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quarto")
public class QuartoAPI {
    private final com.example.Hospital.Quarto.QuartoService quartoService;

    @Autowired
    public QuartoAPI(com.example.Hospital.Quarto.QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping("")
    public ResponseEntity<Quarto> cadastrar(@RequestBody Quarto quarto) {
        return ResponseEntity.ok(this.quartoService.cadastrar(quarto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> pegarPorId(Integer id) {
        return ResponseEntity.ok(this.quartoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quarto> deletarPorId(Integer id) {
        this.quartoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
