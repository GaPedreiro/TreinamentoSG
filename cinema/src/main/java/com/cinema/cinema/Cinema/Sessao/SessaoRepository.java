package com.cinema.cinema.Cinema.Sessao;

import com.cinema.cinema.Cinema.Filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM sessao WHERE numero_sessao ILIKE :numero_sessao")
    List<Sessao> findAllById(@Param("numero_sessao") Integer numero_sesao);
}
