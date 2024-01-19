package com.cinema.cinema.Cinema.Pessoa;

import com.cinema.cinema.Cinema.Sessao.Sessao;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.SingularAttribute;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa pegarPorId(Integer id) {
        return this.pessoaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.pessoaRepository.deleteById(id);
    }
}
