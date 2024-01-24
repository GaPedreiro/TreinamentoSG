package com.example.Hospital.Ala;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AlaService {
    private final AlaRepository alaRepository;

    @Autowired
    public AlaService(AlaRepository alaRepository) {
        this.alaRepository = alaRepository;
    }

    @Transactional
    public Ala cadastrar(Ala ala) {
        return this.alaRepository.save(ala);
    }

    public Ala pegarPorId(Integer id) {
        return this.alaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.alaRepository.deleteById(id);
    }
}
