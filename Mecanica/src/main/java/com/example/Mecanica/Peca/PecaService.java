package com.example.Mecanica.Peca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PecaService {
    private final PecaRepository pecaRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    @Transactional
    public Peca cadastrar(Peca peca) {
        this.validarPeca(peca);
        return this.pecaRepository.save(peca);
    }

    public Peca pegarPorId(Integer id) {
        return this.pecaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.pecaRepository.deleteById(id);
    }

    public void validarPeca(Peca peca) {
        if (Objects.isNull(peca.getNome()) || peca.getNome().isEmpty()) {
            throw new RuntimeException("Peça sem nome.");
        }
        if (Objects.isNull(peca.getFabricante()) || peca.getFabricante().isEmpty()) {
            throw new RuntimeException("Peça sem fabricante.");
        }
        if (Objects.isNull(peca.getQuantidadeEstoque()) || peca.getQuantidadeEstoque() < 0) {
            throw new RuntimeException("Valor para estoque inválido.");
        }
        if (Objects.isNull(peca.getPrecoUnitario()) || peca.getPrecoUnitario() < 0) {
            throw new RuntimeException("Valor unitário inválido");
        }
    }


}
