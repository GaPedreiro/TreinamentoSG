package com.example.Hospital.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM paciente WHERE id ILIKE :id")
    List<Paciente> findAllById(@Param("id") Integer id);
}
