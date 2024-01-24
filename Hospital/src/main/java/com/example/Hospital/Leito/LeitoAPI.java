package com.example.Hospital.Leito;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leito")
public class LeitoAPI {
    private final com.example.Hospital.Leito.LeitoService leitoService;

    @Autowired
    public LeitoAPI(com.example.Hospital.Leito.LeitoService leitoService) {
        this.leitoService = leitoService;
    }

    @PostMapping("")
    public ResponseEntity<Leito> cadastrar(@RequestBody Leito leito) {
        return ResponseEntity.ok(this.leitoService.cadastrar(leito));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Leito> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.leitoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.leitoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

}
