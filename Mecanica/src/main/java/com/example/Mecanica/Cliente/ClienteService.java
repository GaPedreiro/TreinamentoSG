package com.example.Mecanica.Cliente;

import com.example.Mecanica.Peca.Peca;
import com.example.Mecanica.Peca.PecaRepository;
import lombok.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        this.validarCliente(cliente);
        return this.clienteRepository.save(cliente);
    }

    public Cliente pegarPorId(Integer id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPorId(Integer id) {
        this.clienteRepository.deleteById(id);
    }

    public void validarCliente(Cliente cliente) {
        if (Objects.isNull(cliente.getNome()) || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Cliente sem nome.");
        }
        if (Objects.isNull(cliente.getCpf()) || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("CPF do cliente está inválido.");
        }
    }
}
