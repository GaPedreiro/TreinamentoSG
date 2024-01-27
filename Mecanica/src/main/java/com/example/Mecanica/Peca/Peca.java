package com.example.Mecanica.Peca;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "peca")
public class Peca {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    @Column(name = "preco_unitario")
    private double precoUnitario;

    @Column(name = "data_de_cadastro")
    private Date dataDeCadastro = new Date();

    public Peca(String nome, String fabricante, int quantidadeEstoque, double precoUnitario, Date dataDeCadastro) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoUnitario = precoUnitario;
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void entradaEstoque(int valor) {
        this.quantidadeEstoque += valor;
    }

    public void retiradaEstoque(int valor) {
        this.quantidadeEstoque -= valor;
    }

}
