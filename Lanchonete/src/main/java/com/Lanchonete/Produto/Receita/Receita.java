package com.Lanchonete.Produto.Receita;

import com.Lanchonete.Produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "receita")
public class Receita {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

//    @Column(name = "ingredientes")
//    private List<Produto> ingredientesList = new ArrayList<>();

    // Eu chamo recita em venda ou venda em receita?

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "receitas_id")
//    private List<Venda> vendaList = new ArrayList<>();

    public Receita(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

//    public List<Produto> getIngredientesList() {
//        return ingredientesList;
//    }

    //alguma coisa aqui está quebrando.
}
