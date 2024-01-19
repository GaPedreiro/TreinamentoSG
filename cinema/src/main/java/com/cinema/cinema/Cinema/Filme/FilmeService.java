package com.cinema.cinema.Cinema.Filme;

import com.cinema.cinema.Cinema.Sessao.Sessao;
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

    // Parei aqui, criar um DTO para automatizar a criação de sessões e de assentos ao ser criado um filme.

    @Transactional
    public void gerarSessoesAssentos(GerarSessoesAssentosDTO dto) {
        Filme filme = this.pegarPorId(dto.getFilmeId());

        if (Objects.nonNull(filme)) {
            this.cadastrar(filme);
            // fazer 5 sessoes por dia, cada sessao tem 50 assentos.

            // CASCADE
            // trocar o identificador da sessao do filme de numero_sessao para id

            // criar minhas sessoes
            // criar meus assentos
        } else {
            throw new RuntimeException("Não há filme com esse código.");
        }
    }

}
