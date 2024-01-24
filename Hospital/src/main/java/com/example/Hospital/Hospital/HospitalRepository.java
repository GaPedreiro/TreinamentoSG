package com.example.Hospital.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    @Query (nativeQuery = true,
        value = "SELECT * FROM hopital WHERE id ILIKE :id")
    List<Hospital> findAllById(@Param("id") Integer id);
}
