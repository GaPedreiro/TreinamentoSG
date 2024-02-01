package com.Lanchonete.Produto.Receita.ItemReceita;

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
    private Integer id;

    @Column(name = "quantidade")
    private double quantidade;

    public ItemReceita(double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public double getQuantidade() {
        return quantidade;
    }
}
