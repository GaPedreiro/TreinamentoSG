package com.Lanchonete.Produto;

import com.Lanchonete.LOG.ClienteLOG.Log;
import com.Lanchonete.LOG.ClienteLOG.LogRepository;
import com.Lanchonete.LOG.ClienteLOG.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    private final LogService logService;

    private final LogRepository logRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, LogService logService, LogRepository logRepository) {
        this.produtoRepository = produtoRepository;
        this.logService = logService;
        this.logRepository = logRepository;
    }

    @Transactional
    public Produto cadastrar(Produto produto) {

        produto.setEstoque(0.0);
        Log log = new Log(produto.getEstoque());
        produto.getLogList().add(log);
        this.produtoRepository.save(produto);

        return produto;
    }

    public Produto pegarPorId(Integer id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    //PRA AVANÇAR AQUI VAMOS TER QUE CRIAR OUTRA TABELA DE LOG, PROPRIA PARA PRODUTOS
    // NÃO DA PRA UTILIZAR A MESMA DE LOG DE CLIENTES. RETIRAR CASCADE DAQUI DEPOIS.
}
