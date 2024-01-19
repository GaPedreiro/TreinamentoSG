package com.example.Biblioteca.Livro;

//import com.cinema.cinema.Cinema.Sessao.Sessao;
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
@Entity(name = "livro")
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "situacao")
    private boolean situacao;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "quantidade_total")  // Inicialmente deve ser igual a quantidade disponível.
    private int quantidadeTotal;

    @Column(name = "quantidade_disponivel")
    private int quantidadeDisponivel;

    @Column(name = "quantidade_alugada")
    private int quantidadeAlugada;
}
