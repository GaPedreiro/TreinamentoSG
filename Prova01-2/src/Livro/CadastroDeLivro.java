package Livro;

import java.util.Date;

public class CadastroDeLivro {
    private int idLivro;
    private String nomeLivro;
    private boolean statusLivro;
    private Date data;
    private int quantidadeLivro;
    private int quantidadeDisponivel;
    private int quantidadeAlugada;

    public CadastroDeLivro(int idLivro, String nomeLivro, Date data, int quantidadeLivro, int quantidadeDisponivel) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.statusLivro = true;
        this.data = data;
        this.quantidadeLivro = quantidadeLivro;
        this.quantidadeDisponivel = quantidadeLivro;
        this.quantidadeAlugada = 0;
    }

    public CadastroDeLivro() {}

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public boolean getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(boolean statusLivro) {
        this.statusLivro = statusLivro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidadeLivro() {
        return quantidadeLivro;
    }

    public void setQuantidadeLivro(int quantidadeLivro) {
        this.quantidadeLivro = quantidadeLivro;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getQuantidadeAlugada() {
        return quantidadeAlugada;
    }

    public void setQuantidadeAlugada(int quantidadeAlugada) {
        this.quantidadeAlugada = quantidadeAlugada;
    }
}
