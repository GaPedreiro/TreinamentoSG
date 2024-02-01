package com.Lanchonete.Produto;

import com.Lanchonete.LOG.ProdutoLOG.LogProduto;
import com.Lanchonete.LOG.ProdutoLOG.LogProdutoRepository;
import com.Lanchonete.LOG.ProdutoLOG.LogProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    private final LogProdutoService logProdutoService;

    private final LogProdutoRepository logProdutoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, LogProdutoService logProdutoService, LogProdutoRepository logProdutoRepository) {
        this.produtoRepository = produtoRepository;
        this.logProdutoService = logProdutoService;
        this.logProdutoRepository = logProdutoRepository;
    }

    @Transactional
    public Produto cadastrar(Produto produto) {

        produto.setEstoque(0.0);
        LogProduto logProduto = new LogProduto(produto.getEstoque());
        produto.getLogProdutoList().add(logProduto);
        this.produtoRepository.save(produto);

        return produto;
    }

    public Produto pegarPorId(Integer id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.produtoRepository.deleteById(id);
    }

    @Transactional
    public Produto adicionarEstoquePorId(Integer id, double valor) {
        Produto produto = this.produtoRepository.findById(id).orElse(null);
        double novoEstoque = produto.getEstoque() + valor;
        produto.setEstoque(novoEstoque);
        LogProduto logProduto = new LogProduto(produto.getEstoque());
        produto.getLogProdutoList().add(logProduto);
        return null;
    }

    @Transactional
    public Produto retirarEstoquePorId(Integer id, double valor) {
        Produto produto = this.produtoRepository.findById(id).orElse(null);
        double novoEstoque = produto.getEstoque() - valor;
        produto.setEstoque(novoEstoque);
        LogProduto logProduto = new LogProduto(produto.getEstoque());
        produto.getLogProdutoList().add(logProduto);
        return null;
    }
}
