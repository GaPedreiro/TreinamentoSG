package com.Lanchonete.Produto.Receita.ItemReceita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;
@Repository
public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM item_receita i WHERE i.id ILIKE :id")
    List<ItemReceita> findAllById(@Param("id") Integer id);
}
