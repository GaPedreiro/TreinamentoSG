package com.Lanchonete.LOG.ClienteLOG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional
    public Log cadastrar(Log log) {
        return this.logRepository.save(log);
    }

    public Log pegarPorId(Integer id) {
        return this.logRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.logRepository.deleteById(id);
    }

}
