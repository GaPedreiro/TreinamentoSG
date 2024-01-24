package com.example.Hospital.LogInternacoes;

import com.example.Hospital.Leito.Leito;
import com.example.Hospital.Leito.LeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogInternacoesService {
    private final LogInternacoesRepository logInternacoesRepository;

    @Autowired
    public LogInternacoesService(LogInternacoesRepository logInternacoesRepository) {
        this.logInternacoesRepository = logInternacoesRepository;
    }

    @Transactional
    public LogInternacoes cadastrar(LogInternacoes logInternacoes) {
        return this.logInternacoesRepository.save(logInternacoes);
    }

    public LogInternacoes pegarPorId(Integer id) {
        return this.logInternacoesRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.logInternacoesRepository.deleteById(id);
    }
}
