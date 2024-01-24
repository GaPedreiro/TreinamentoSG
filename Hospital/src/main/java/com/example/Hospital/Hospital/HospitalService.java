package com.example.Hospital.Hospital;

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
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
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

    /*
    @Transactional(readOnly = true)
    public List<Hospital> findByNome {
        return this.hospitalRepository.findAllByNome("%" + nome + "%");
    }

     */


}
