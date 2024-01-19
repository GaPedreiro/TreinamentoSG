package com.cinema.cinema.Cinema.Pessoa;

import com.cinema.cinema.Cinema.Filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM pessoa WHERE id ILIKE :id")
    List<Pessoa> findAllById(@Param("id") Integer id);
}
