package com.cinema.cinema.Cinema.Filme;

import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public Filme cadastrar(Filme filme) {
        return this.filmeRepository.save(filme);
    }

    /*
    public Filme atualizar(Filme filme) {
        return this.filmeRepository.
    }

     */

    public Filme pegarPorId(Integer id) {
        return this.filmeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.filmeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Filme> findByNome(String nome) {
        return this.filmeRepository.findAllByNome("%" + nome + "%");
    }
}
