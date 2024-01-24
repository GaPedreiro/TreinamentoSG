package com.example.Hospital.Quarto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM quarto WHERE id ILIKE :id")
    List<Quarto> findAllById(@Param("id") Integer id);
}
