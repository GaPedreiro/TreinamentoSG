package com.example.Biblioteca.IdentificadorDeLivro;

import com.example.Biblioteca.Livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IdentificadorDeLivroRepository extends JpaRepository<IdentificadorDeLivro, Integer>{
    @Query(nativeQuery = true,
            value = "SELECT * FROM identificador_de_livro WHERE id ILIKE :id")
    List<IdentificadorDeLivro> findAllById(@Param("id") Integer id);
}
