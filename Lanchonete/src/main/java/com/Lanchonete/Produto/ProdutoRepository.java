package com.Lanchonete.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM produto p WHERE p.id ILIKE :id")
    List<Produto> findAllById(@Param("id") Integer id);
}
