package com.Lanchonete.LOG.ProdutoLOG;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface LogProdutoRepository  extends JpaRepository<LogProduto, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM log_produto p WHERE p.id ILIKE :id")
    List<LogProduto> findAllById(@Param("id") Integer id);
}
