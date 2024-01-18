package com.cinema.cinema.Cinema.Filme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class GerarSessoesAssentosDTO {
    Integer filmeId;
    Integer numeroDeSessoes;
    Integer numeroDeAssentos;
    Date dataInicioDoFilme;

    public Date getDataInicioDoFilme() {
        return dataInicioDoFilme;
    }

    public Integer getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }

    public Integer getNumeroDeSessoes() {
        return numeroDeSessoes;
    }

    public void setNumeroDeSessoes(Integer numeroDeSessoes) {
        this.numeroDeSessoes = numeroDeSessoes;
    }

    public Integer getNumeroDeAssentos() {
        return numeroDeAssentos;
    }

    public void setNumeroDeAssentos(Integer numeroDeAssentos) {
        this.numeroDeAssentos = numeroDeAssentos;
    }
    // id, numeroSessao por dia, numeroAssentos por sessao



}
