package com.Lanchonete.Cliente;

import jakarta.websocket.ClientEndpoint;
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

    // Validação dos dados do cliente.

    public void validarCliente(Cliente cliente) {
        if (Objects.isNull(cliente.getNome()) || cliente.getNome().isEmpty()) {
            throw new RuntimeException("O nome do cliente é iválido.");
        }
        if (Objects.isNull(cliente.getSaldo())) {
            throw new RuntimeException(("O saldo do cliente é inválido."));
        }
        if (cliente.getSaldo() < 0) {
            throw new RuntimeException("O saldo do cliente não pode ser menor que zero, não vendemos fiado.");
        }
        if (Objects.isNull(cliente.getCpf()) || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF do cliente é inválido");
        }
    }
}
