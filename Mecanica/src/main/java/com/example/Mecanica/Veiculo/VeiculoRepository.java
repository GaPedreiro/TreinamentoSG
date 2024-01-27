package com.example.Mecanica.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends  JpaRepository<Veiculo, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM veiculo l WHERE l.id ILIKE :id")
    List<Veiculo> findAllById(@Param("id") Integer id);
}
