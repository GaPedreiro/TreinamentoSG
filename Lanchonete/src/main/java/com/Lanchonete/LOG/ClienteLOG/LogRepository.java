package com.Lanchonete.LOG.ClienteLOG;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM log l WHERE l.id ILIKE :id")
    List<Log> findAllById(@Param("id") Integer id);
}
