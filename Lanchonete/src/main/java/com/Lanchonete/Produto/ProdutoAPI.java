package com.Lanchonete.Produto;

import com.Lanchonete.LOG.ProdutoLOG.LogProdutoAPI;
import com.Lanchonete.LOG.ProdutoLOG.LogProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
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

    @PostMapping("")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.produtoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarPorId(@PathVariable Integer id) {
        this.produtoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    //Rotas de movimentaçõe no estoque.

    @PostMapping("/adicionar/{id}/{valor}")
    public ResponseEntity<Produto> adicionarEstoquePorId(@PathVariable Integer id, @PathVariable double valor) {
        return ResponseEntity.ok(this.produtoService.adicionarEstoquePorId(id, valor));
    }

    @PostMapping("/retirar/{id}/{valor}")
    public ResponseEntity<Produto> retirarEstoquePorId(@PathVariable Integer id, @PathVariable double valor) {
        return ResponseEntity.ok(this.produtoService.retirarEstoquePorId(id, valor));
    }

}
