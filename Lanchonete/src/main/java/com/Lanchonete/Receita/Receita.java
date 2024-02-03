package com.Lanchonete.Receita;

import com.Lanchonete.ItemReceita.ItemReceita;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receita_id")
    private List<ItemReceita> ingredientesList = new ArrayList<>();

    @Column(name = "preco")
    private double preco;

    @Column(name = "custo")
    private double custo;

    public Receita(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ItemReceita> getIngredientesList() {
        return ingredientesList;
    }
}
