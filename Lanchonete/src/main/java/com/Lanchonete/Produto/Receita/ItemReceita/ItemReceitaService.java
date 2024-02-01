package com.Lanchonete.Produto.Receita.ItemReceita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemReceitaService {
    private final ItemReceitaRepository itemReceitaRepository;

    @Autowired
    public ItemReceitaService(ItemReceitaRepository itemReceitaRepository) {
        this.itemReceitaRepository = itemReceitaRepository;
    }

    @Transactional
    public ItemReceita cadastrar(ItemReceita itemReceita) {
        return this.itemReceitaRepository.save(itemReceita);
    }

    public ItemReceita pegarPorId(Integer id) {
        return this.itemReceitaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.itemReceitaRepository.deleteById(id);
    }
}
