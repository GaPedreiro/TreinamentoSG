package com.example.Biblioteca.Livro;

import jakarta.annotation.security.PermitAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
    @Query(nativeQuery = true,
            value = "SELECT * FROM livro WHERE id ILIKE :id")
    List<Livro> findAllById(@Param("id") Integer id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM livro WHERE nome ILIKE :nome")
    List<Livro> findAllByNome(@Param("nome") String nome);
}
