package com.example.Mecanica.Cliente;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {
    private final com.example.Mecanica.Cliente.ClienteService clienteService;

    @Autowired
    public ClienteAPI(com.example.Mecanica.Cliente.ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.cadastrar(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.clienteService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.clienteService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
