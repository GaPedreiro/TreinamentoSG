package Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    private String nomeProduto;
    private boolean statusProduto;
    private int estoqueProduto;

    private int idProduto;

    public Produto(String nomeProduto, int estoqueProduto, int idProduto) {
        this.nomeProduto = nomeProduto;
        this.statusProduto = true;
        this.estoqueProduto = estoqueProduto;
        this.idProduto = idProduto;
    }

    Scanner read = new Scanner(System.in);

    public Produto() {} // Construtor default chamado em ListagemDeProdutos.

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public boolean getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(boolean statusProduto) {
        this.statusProduto = statusProduto;
    }

    public int getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int contadorId() {
        return this.idProduto = idProduto++;
    }
}