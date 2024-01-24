package com.example.Hospital.Paciente;

import jakarta.persistence.criteria.CriteriaBuilder;
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
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public Paciente cadastrar(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }

    public Paciente pegarPorId(Integer id) {
        return this.pacienteRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.pacienteRepository.deleteById(id);
    }
}
