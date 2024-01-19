package com.cinema.cinema.Cinema.Filme;

import com.cinema.cinema.Cinema.Sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "filme")
public class Filme {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "em_cartaz")
    private boolean emCartaz;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id")
    private List<Sessao> sessaoList;

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }
}