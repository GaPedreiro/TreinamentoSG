package com.example.Mecanica.Veiculo;

import com.example.Mecanica.Peca.Peca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {
        this.validarVeiculo(veiculo);
        return this.veiculoRepository.save(veiculo);
    }

    public void validarVeiculo(Veiculo veiculo) {
        if (Objects.isNull(veiculo.getModelo()) || veiculo.getModelo().isEmpty()) {
            throw new RuntimeException("Modelo sem nome.");
        }
        if (Objects.isNull(veiculo.getMarca()) || veiculo.getMarca().isEmpty()) {
            throw new RuntimeException("Marca sem nome.");
        }
        if (Objects.isNull(veiculo.getAnoDeFabricacao()) || veiculo.getAnoDeFabricacao() < 0) {
            throw new RuntimeException("Ano de fabricação inválido.");
        }
        if (Objects.isNull(veiculo.getKmRodados()) || veiculo.getKmRodados() < 0) {
            throw new RuntimeException("Valor de Km rodados inválido.");
        }
    }

    public Veiculo pegarPorId(Integer id) {
        return this.veiculoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.veiculoRepository.deleteById(id);
    }

}
