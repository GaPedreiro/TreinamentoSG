package com.Lanchonete.Cliente;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {
    private final ClienteService clienteService; //Pra poder usar os métodos definidos nela.

    @Autowired
    public ClienteAPI(ClienteService clienteService) {
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
    public ResponseEntity<Cliente> deletarPorId(@PathVariable Integer id) {
        this.clienteService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/{id}")
    public
}
