package com.example.Hospital.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteAPI {
    private final com.example.Hospital.Paciente.PacienteService pacienteService;

    @Autowired
    private PacienteAPI(com.example.Hospital.Paciente.PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("")
    private ResponseEntity<Paciente> cadastrar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(this.pacienteService.cadastrar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pacienteService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletarPorId(@PathVariable Integer id) {
        this.pacienteService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
