package com.example.Biblioteca.Pessoa;

import com.example.Biblioteca.Livro.Livro;
import jakarta.annotation.security.PermitAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    @Query(nativeQuery = true,
            value = "SELECT * FROM pessoa WHERE id ILIKE :id")
    List<Livro> findAllById(@Param("id") Integer id);
}
