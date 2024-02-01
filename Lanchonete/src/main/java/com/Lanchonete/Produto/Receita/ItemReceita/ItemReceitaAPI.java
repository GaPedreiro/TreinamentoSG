package com.Lanchonete.Produto.Receita.ItemReceita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ItemReceitaAPI {
    private final ItemReceitaService itemReceitaService;

    @Autowired
    public ItemReceitaAPI(ItemReceitaService itemReceitaService) {
        this.itemReceitaService = itemReceitaService;
    }

    @PostMapping("")
    public ResponseEntity<ItemReceita> cadastrar(@RequestBody ItemReceita itemReceita) {
        return ResponseEntity.ok(this.itemReceitaService.cadastrar(itemReceita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemReceita> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.itemReceitaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemReceita> deletarPorId(@PathVariable Integer id) {
        this.itemReceitaService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
