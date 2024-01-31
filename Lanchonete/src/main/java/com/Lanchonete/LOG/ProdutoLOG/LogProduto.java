package com.Lanchonete.LOG.ProdutoLOG;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "log_produto")
public class LogProduto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "estoque")
    private double estoque;

    public LogProduto(double estoque) {
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public double getEstoque() {
        return estoque;
    }
}
