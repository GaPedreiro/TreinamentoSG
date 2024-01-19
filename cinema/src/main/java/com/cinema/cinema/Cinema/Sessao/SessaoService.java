package com.cinema.cinema.Cinema.Sessao;

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
public class SessaoService {
    private final SessaoRepository sessaoRepository;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    @Transactional
    public Sessao cadastrar(Sessao sessao) {
        return this.sessaoRepository.save(sessao);
    }

    public Sessao pegarPorId(Integer id) {
        return this.sessaoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.sessaoRepository.deleteById(id);
    }
}
