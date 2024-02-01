package com.Lanchonete.Produto;

import com.Lanchonete.LOG.ClienteLOG.Log;
import com.Lanchonete.LOG.ProdutoLOG.LogProduto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private double preco;

    @Column(name = "estoque")
    private double estoque;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<LogProduto> logProdutoList = new ArrayList<>();

    // Provavelmente a tabela "Receita" terá um produtoID, implementado aqui com cascade.


    public Produto(String nome, double preco, double estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public void entraEstoque(double valor) {
        this.estoque += valor;
    }

    public void retiraEstoque(double valor) {
        this.estoque -= valor;
    }

    public List<LogProduto> getLogProdutoList() {
        return logProdutoList;
    }
}
