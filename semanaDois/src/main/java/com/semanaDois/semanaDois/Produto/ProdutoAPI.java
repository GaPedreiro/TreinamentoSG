package com.semanaDois.semanaDois.Produto;

import com.semanaDois.semanaDois.Produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoAPI {
    private final com.semanaDois.semanaDois.Produto.ProdutoService produtoService;

    @Autowired
    public ProdutoAPI(com.semanaDois.semanaDois.Produto.ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("") // http://127.0.0.1:8080/produto -Aqui no caso, tem que ser passado um JSON contendo o nome.
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    @GetMapping("/{id}")  // http://127.0.0.1:8080/produto/2
    public ResponseEntity<Produto> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.produtoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}") // http://127.0.0.1:8080/produto/2
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.produtoService.deletarProduto(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome") // http://127.0.0.1:8080/produto/por-nome?nome=Testee -Exemplo de como ficaria a rota.
    public ResponseEntity<List<Produto>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.produtoService.findByNome(nome));
    }
}
