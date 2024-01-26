package com.example.Mecanica.Peca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM peca l WHERE l.id ILIKE :id")
    List<Peca> findAllById(@Param("id") Integer id);
}
