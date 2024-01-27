package com.example.Mecanica.Veiculo;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoAPI {
    private final com.example.Mecanica.Veiculo.VeiculoService veiculoService;

    @Autowired
    public VeiculoAPI(com.example.Mecanica.Veiculo.VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping("")
    public ResponseEntity<Veiculo> cadastrar(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(this.veiculoService.cadastrar(veiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> pegarPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(this.veiculoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.veiculoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
