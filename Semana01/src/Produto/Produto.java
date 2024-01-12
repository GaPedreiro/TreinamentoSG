package Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Produto {
    private String nomeProduto;
    private boolean statusProduto;
    private int estoqueProduto;

    private BigDecimal valorProduto; // ADICIONADO

    private Date data; // ADICIONADO

    private int idProduto;

    public Produto(String nomeProduto, BigDecimal valorProduto, int estoqueProduto, int idProduto, Date data) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.statusProduto = true;
        this.estoqueProduto = estoqueProduto;
        this.idProduto = idProduto;
        this.data = new Date();
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

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
}