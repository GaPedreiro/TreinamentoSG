package com.Lanchonete.LOG.ProdutoLOG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log_produto")
public class LogProdutoAPI {

    private final LogProdutoService logProdutoService;

    @Autowired
    public LogProdutoAPI(LogProdutoService logProdutoService) {
        this.logProdutoService = logProdutoService;
    }

    @PostMapping("")
    public ResponseEntity<LogProduto> cadastrar(@RequestBody LogProduto logProduto) {
        return ResponseEntity.ok(this.logProdutoService.cadastrar(logProduto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogProduto> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.logProdutoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LogProduto> deletarPorId(@PathVariable Integer id) {
        this.logProdutoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
