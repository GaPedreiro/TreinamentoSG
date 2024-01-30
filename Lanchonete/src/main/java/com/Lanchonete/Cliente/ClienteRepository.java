package com.Lanchonete.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM cliente i WHERE i.id ILIKE :id")
    List<Cliente> findAllById(@Param("id") Integer id);
}
