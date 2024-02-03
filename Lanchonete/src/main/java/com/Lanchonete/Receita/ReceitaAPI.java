package com.Lanchonete.Receita;

import com.Lanchonete.ItemReceita.ItemReceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receita")
public class ReceitaAPI {
    private final ReceitaService receitaService;

    @Autowired
    public ReceitaAPI(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping("")
    public ResponseEntity<Receita> cadastrar(@RequestBody Receita receita) {
        return ResponseEntity.ok(this.receitaService.cadastrar(receita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.receitaService.pegarPorId(id));
    }

    @GetMapping("")
    public ResponseEntity<Receita> pegarTodosPorId() {
        return ResponseEntity.ok(this.receitaService.pegarTodosPorId());
    }

    /*
    @PostMapping("/cria_receita/{id}/{id]")
    public ResponseEntity<ItemReceita> criarItemReceitaComReceita(@RequestBody Receita receita, @PathVariable Integer id, @PathVariable double quantidade) {
        //return ResponseEntity.ok(this.receitaService.criarItemReceitaComReceita(receita, id, quantidade));
    }

     */



    @PostMapping("/cria_receita")
    public ResponseEntity<ItemReceita> criarItemReceitaComReceita(@RequestBody Receita receita, @RequestBody ItemReceita itemReceita) {
        return ResponseEntity.ok(this.receitaService.criarItemReceitaComReceita(receita, itemReceita));
    }


}
