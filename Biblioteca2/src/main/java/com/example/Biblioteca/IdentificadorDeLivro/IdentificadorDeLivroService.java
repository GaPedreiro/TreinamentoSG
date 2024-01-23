package com.example.Biblioteca.IdentificadorDeLivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdentificadorDeLivroService {
    private final IdentificadorDeLivroRepository identificadorDeLivroRepository;

    @Autowired
    public IdentificadorDeLivroService(IdentificadorDeLivroRepository identificadorDeLivroRepository) {
        this.identificadorDeLivroRepository = identificadorDeLivroRepository;
    }

    @Transactional
    public IdentificadorDeLivro cadastrar(IdentificadorDeLivro identificadorDeLivro) {
        return this.identificadorDeLivroRepository.save(identificadorDeLivro);
    }

    public IdentificadorDeLivro pegarPorId(Integer id) {
        return this.identificadorDeLivroRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.identificadorDeLivroRepository.deleteById(id);
    }
}
