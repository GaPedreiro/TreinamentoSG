package com.example.Hospital.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalAPI {
    private final com.example.Hospital.Hospital.HospitalService hospitalService;

    @Autowired
    public HospitalAPI(com.example.Hospital.Hospital.HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping("")
    public ResponseEntity<Hospital> cadastrar(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(this.hospitalService.cadastrar(hospital));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.hospitalService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.hospitalService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Hospital>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.hospitalService.findByNome(nome));
    }
}
