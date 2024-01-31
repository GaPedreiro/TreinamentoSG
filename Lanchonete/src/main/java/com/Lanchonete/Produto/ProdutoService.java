package com.Lanchonete.Produto;

import com.Lanchonete.LOG.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

//    @Transactional
//    public Produto cadastrar(Produto produto) {
//        produto.setEstoque(0.0);
//        Log log // CRIAR CASCADE DE PRODUTO COM LOG ANTES.
//    }
}
