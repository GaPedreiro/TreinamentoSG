package com.cinema.cinema.Cinema.Assento;

import com.cinema.cinema.Cinema.Sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "assento")
public class Assento {

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fileira")
    private String fileiraAssento;

    @Column(name = "numero")
    private int numeroAssento;

}