package com.example.Hospital.LogInternacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogInternacoesRepository extends JpaRepository<LogInternacoes, Integer> {
    @Query (nativeQuery = true,
        value = "SELECT * FROM log_internacoes WHERE id ILIKE :id")
    List<LogInternacoes> findAllById(@Param("id") Integer id);
}
