package com.example.Mecanica.Servico;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "servico")
public class Servico {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_mao_de_obra")
    private double precoMaoDeObra;

    @Column(name = "data_de_cadastro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date dataDeCadastro;

    public Servico(String nome, double precoMaoDeObra, Date dataDeCadastro) {
        this.nome = nome;
        this.precoMaoDeObra = precoMaoDeObra;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoMaoDeObra() {
        return precoMaoDeObra;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }
}
