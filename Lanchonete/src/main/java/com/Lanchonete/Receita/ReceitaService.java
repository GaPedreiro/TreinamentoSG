package com.Lanchonete.Receita;

import com.Lanchonete.Produto.Produto;
import com.Lanchonete.Produto.ProdutoRepository;
import com.Lanchonete.Produto.ProdutoService;
import com.Lanchonete.ItemReceita.ItemReceita;
import com.Lanchonete.ItemReceita.ItemReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    private final ProdutoService produtoService;

    private final ItemReceitaRepository itemReceitaRepository;

    private final ProdutoRepository produtoRepository;



    @Autowired
    public ReceitaService(ReceitaRepository receitaRepository, ProdutoService produtoService, ItemReceitaRepository itemReceitaRepository, ProdutoRepository produtoRepository) {
        this.receitaRepository = receitaRepository;
        this.produtoService = produtoService;
        this.itemReceitaRepository = itemReceitaRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Receita cadastrar(Receita receita) {
        //criarItemReceitaComReceita(receita, 2, 1);
        return this.receitaRepository.save(receita);
    }

    public Receita pegarPorId(Integer id) {
        return this.receitaRepository.findById(id).orElse(null);
    }

    public Receita pegarTodosPorId() {
        return (Receita) this.receitaRepository.findAll();
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.receitaRepository.deleteById(id);
    }

    /*
    @Transactional
    public ItemReceita criarItemReceitaComReceita(Receita receita, Integer produtoId, double quantidade) {
        this.receitaRepository.save(receita);
        ItemReceita itemReceita = new ItemReceita(produtoId, quantidade);
        receita.getIngredientesList().add(itemReceita);

        itemReceita = itemReceitaRepository.save(itemReceita);

        for (int i = 0; i < receita.getIngredientesList().size(); i++) {
            Produto produto = this.produtoRepository.findById(produtoId).orElse(null);
            this.produtoService.retirarEstoquePorId(produtoId, quantidade);
            this.produtoService.retirarEstoquePorId(itemReceita.getId(), itemReceita.getQuantidade());
        }

        return itemReceita;
    }

     */

    @Transactional
    //public ItemReceita criarItemReceitaComReceita(Receita receita, Integer produtoId, double quantidade) {
    public ItemReceita criarItemReceitaComReceita(Receita receita, ItemReceita itemReceita) {
        receita.getIngredientesList().add(itemReceita);

        // carambolas

        itemReceita = itemReceitaRepository.save(itemReceita);
        this.receitaRepository.save(receita);

        for (int i = 0; i < receita.getIngredientesList().size(); i++) {
            this.produtoService.retirarEstoquePorId(itemReceita.getId(), itemReceita.getQuantidade());
        }
        return null;
    }
}
