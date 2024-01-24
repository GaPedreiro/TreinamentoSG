/*
package com.example.Hospital.Ala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlaRepository extends JpaRepository<Ala, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM ala WHERE id ILIKE :ID")
    List<Ala> findAllById(@Param("id") Integer id);
}


 */