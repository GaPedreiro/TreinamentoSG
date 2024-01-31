package com.Lanchonete.LOG.ProdutoLOG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogProdutoService {

    private final LogProdutoRepository logProdutoRepository;

    @Autowired
    public LogProdutoService(LogProdutoRepository logProdutoRepository) {
        this.logProdutoRepository = logProdutoRepository;
    }

    @Transactional
    public LogProduto cadastrar(LogProduto logProduto) {
        return this.logProdutoRepository.save(logProduto);
    }

    public LogProduto pegarPorId(Integer id) {
        return this.logProdutoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.logProdutoRepository.deleteById(id);
    }
}
