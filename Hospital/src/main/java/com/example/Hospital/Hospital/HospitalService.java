package com.example.Hospital.Hospital;

import com.example.Hospital.Ala.Ala;
import com.example.Hospital.Ala.AlaRepository;
import com.example.Hospital.Ala.AlaService;
import com.example.Hospital.Leito.LeitoRepository;
import com.example.Hospital.Quarto.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public AlaRepository alaRepository;

    @Autowired
    public QuartoRepository quartoRepository;

    @Autowired
    public LeitoRepository leitoRepository;



    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Ala criarAlaQuartoLeito(Hospital hospital, String especialidade, int quantidadeQuartos, int quantidadeDeLeitosPorQuarto) {
        Ala ala = new Ala();

        ala.setEspecialidade(especialidade);
        ala.setHospital(hospital);

    }

    @Transactional
    public Hospital cadastrar(Hospital hospital) {
        return this.hospitalRepository.save(hospital);
    }

    public Hospital pegarPorId(Integer id) {
        return this.hospitalRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.hospitalRepository.deleteById(id);
    }

    public List<Hospital> findByNome(String nome) {
        return this.hospitalRepository.findAllByNome("%" + nome + "%");
    }

    /*
    @Transactional(readOnly = true)
    public List<Hospital> findByNome {
        return this.hospitalRepository.findAllByNome("%" + nome + "%");
    }

     */




}
