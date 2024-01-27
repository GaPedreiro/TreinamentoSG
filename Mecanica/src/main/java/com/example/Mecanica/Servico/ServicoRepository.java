package com.example.Mecanica.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends  JpaRepository<Servico, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM servico l WHERE l.id ILIKE :id")
    List<Servico> findAllById(@Param("id") Integer id);
}
