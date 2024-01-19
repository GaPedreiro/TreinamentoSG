package com.cinema.cinema.Cinema.Assento;

import com.cinema.cinema.Cinema.Sessao.Sessao;
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
public class AssentoService {

    private final AssentoRepository assentoRepository;

    @Autowired
    public AssentoService(AssentoRepository assentoRepository) {
        this.assentoRepository = assentoRepository;
    }

    @Transactional
    public Assento cadastrar(Assento assento) {
        return this.assentoRepository.save(assento);
    }

    public Assento pegarPorId(Integer id) {
        return this.assentoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.assentoRepository.deleteById(id);
    }
}
