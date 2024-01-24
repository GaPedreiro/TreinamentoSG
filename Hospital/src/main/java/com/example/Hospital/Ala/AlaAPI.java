package com.example.Hospital.Ala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ala")
public class AlaAPI {
    private final com.example.Hospital.Ala.AlaService alaService;

    @Autowired
    public AlaAPI(com.example.Hospital.Ala.AlaService alaService) {
        this.alaService = alaService;
    }

    @PostMapping("")
    public ResponseEntity<Ala> cadastrar(@RequestBody Ala ala) {
        return ResponseEntity.ok(this.alaService.cadastrar(ala));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ala> pegarPorId(Integer id) {
        return ResponseEntity.ok(this.alaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ala> deletarPorId(Integer id) {
        this.alaService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
