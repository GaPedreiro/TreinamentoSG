package com.example.Mecanica.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    // QUEBRANDO AQUI.
    @Transactional
    public Servico cadastrar(Servico servico) {
        this.validarServico(servico);
        return this.servicoRepository.save(servico);
    }

    public void validarServico(Servico servico) {
        if (Objects.isNull(servico.getNome()) || servico.getNome().isEmpty()) {
            throw new RuntimeException("Serviço sem nome.");
        }
        if (Objects.isNull(servico.getPrecoMaoDeObra()) || servico.getPrecoMaoDeObra() < 0) {
            throw new RuntimeException("Valor de mão de obra inválido.");
        }
    }

    public Servico pegarPorId(Integer id) {
        return this.servicoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.servicoRepository.deleteById(id);
    }

}
