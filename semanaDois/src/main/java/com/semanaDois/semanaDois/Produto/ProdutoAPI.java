package com.semanaDois.semanaDois.Produto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/produto")
public class ProdutoAPI {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoAPI(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }
}
