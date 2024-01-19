package com.cinema.cinema.Cinema.Sessao;

import com.cinema.cinema.Cinema.Assento.Assento;
import com.cinema.cinema.Cinema.Filme.Filme;
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
@Entity(name = "sessao")
public class Sessao {


    @Id
    @Column(name = "sessao_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numero_sessao")
    private int numeroSessao;

    @Column(name = "hora_inicio")
    private Date horaInicio;
    @Column(name = "hora_termino")
    private Date horaTermino;

    @ManyToOne
    @JoinColumn(name = "flime_id")
    private Filme filme;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessao")
    //@JoinColumn(name = "sessao_id")
    private List<Assento> assentoList;
}