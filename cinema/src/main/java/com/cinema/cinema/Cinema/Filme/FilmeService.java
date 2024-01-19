package com.cinema.cinema.Cinema.Filme;

import com.cinema.cinema.Cinema.Assento.Assento;
import com.cinema.cinema.Cinema.Dtos.GerarSessoesAssentosDTO;
import com.cinema.cinema.Cinema.Sessao.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            //this.cadastrar(filme);

            for (int i = 0; i < 3; i++) {
                Sessao sessao = new Sessao();
                sessao.setNumeroSessao(i);
                sessao.setHoraInicio(new Date());
                sessao.setHoraTermino(new Date());

                for (int j = 0; j < 10; j++) {
                    Assento assento = new Assento();
                    sessao.getAssentoList().add(assento);
                }
                filme.getSessaoList().add(sessao);
            }
            this.cadastrar(filme);

        } else {
            throw new RuntimeException("Não há filme com esse código.");
        }
    }

}
