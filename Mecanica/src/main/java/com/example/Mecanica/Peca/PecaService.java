package com.example.Mecanica.Peca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PecaService {
    private final PecaRepository pecaRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    @Transactional
    public Peca cadastrar(Peca peca) {
        return this.pecaRepository.save(peca);
    }

    public Peca pegarPorId(Integer id) {
        return this.pecaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.pecaRepository.deleteById(id);
    }
}
