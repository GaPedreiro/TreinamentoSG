package Produto;

public class Produto {
    private String nomeProduto;
    private boolean statusProduto;
    private int estoqueAtualProduto;

    public Produto(String nomeProduto, int estoqueAtualProduto) {
        this.nomeProduto = nomeProduto;
        this.statusProduto = true;
        this.estoqueAtualProduto = estoqueAtualProduto;
    }

    // SET NOME
    public void setNomeProduto(String nome) {
        this.nomeProduto = nome;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    // SET ESTOQUE
    public void setEstoqueAtualProduto(int valor) {
        this.estoqueAtualProduto = valor;
    }

    public int getEstoqueAtualProduto() {
        return estoqueAtualProduto;
    }

    // SET STATUS
    public void setStatusProduto(boolean status) {
        this.statusProduto = status;
    }

    public boolean getStatusProduto() {
        return statusProduto;
    }
}
