package com.Lanchonete.ItemReceita;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "item_receita")
public class ItemReceita {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "quantidade")
    private double quantidade;

    public ItemReceita(Integer produtoId, double quantidade) {
        this.quantidade = quantidade;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
