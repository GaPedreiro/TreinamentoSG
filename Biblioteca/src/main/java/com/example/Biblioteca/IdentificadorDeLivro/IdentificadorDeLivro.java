package com.example.Biblioteca.IdentificadorDeLivro;

import com.example.Biblioteca.Livro.Livro;
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
@Entity(name = "identificadorDeLivro")
public class IdentificadorDeLivro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "idDaPessoa") // Inicialmente nulo.
    private Integer idDaPessoa;

    @Column(name = "numeroDoLivro")
    private int numeroDoLivro;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id")
    private List<Livro> livro;

     */
}
