package com.example.Biblioteca.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Livro cadastrar(Livro livro) {
        livro.defineQuantidadeTotalInicial();
        return this.livroRepository.save(livro);

    }

    public Livro pegarPorId(Integer id) {
        return this.livroRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        Livro livro = new Livro();
        if (livro.isReservado()) {
            this.livroRepository.deleteById(id);
        } else {
            System.out.println(livro.getQuantidadeAlugada());
            System.out.println("Este livro não pode ser deletado, existe um exemplar reservado.");
        }
    }

    @Transactional(readOnly = true)
    public List<Livro> findByNome(String nome) {
        return this.livroRepository.findAllByNome("%" + nome + "%");
    }

}