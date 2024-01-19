package com.cinema.cinema.Cinema.Assento;

import com.cinema.cinema.Cinema.Filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssentoRepository  extends  JpaRepository<Assento, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM assento WHERE id ILIKE :id")
    List<Assento> findAllById(@Param("id") Integer id);
}
