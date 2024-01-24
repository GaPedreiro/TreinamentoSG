package com.example.Hospital.Quarto;

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
public class QuartoService {
    private final QuartoRepository quartoRepository;

    @Autowired
    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    @Transactional
    public Quarto cadastrar(Quarto quarto) {
        return this.quartoRepository.save(quarto);
    }

    public Quarto pegarPorId(Integer id) {
        return this.quartoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.quartoRepository.deleteById(id);
    }
}
