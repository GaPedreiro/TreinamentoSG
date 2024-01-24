package com.example.Hospital.Leito;

import com.example.Hospital.Hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeitoRepository extends JpaRepository<Leito, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM leito WHERE id ILIKE :id")
    List<Hospital> findAllById(@Param("id") Integer id);
}
