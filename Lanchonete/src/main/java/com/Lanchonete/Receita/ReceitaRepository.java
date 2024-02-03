package com.Lanchonete.Receita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReceitaRepository extends  JpaRepository<Receita, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM receita r WHERE r.id ILIKE :id")
    List<Receita> findAllById(@Param("id") Integer id);

    @Query(nativeQuery = true,
        value = "SELECT * FROM receita")
    List<Receita> findAll();
}
