package com.example.Hospital.Leito;

import com.example.Hospital.Hospital.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeitoService {

    private final LeitoRepository leitoRepository;

    @Autowired
    public LeitoService(LeitoRepository leitoRepository) {
        this.leitoRepository = leitoRepository;
    }

    @Transactional
    public Leito cadastrar(Leito leito) {
        return this.leitoRepository.save(leito);
    }

    public Leito pegarPorId(Integer id) {
        return this.leitoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.leitoRepository.deleteById(id);
    }

}
