package com.Lanchonete.Cliente;

import com.Lanchonete.LOG.Log;
import com.Lanchonete.LOG.LogRepository;
import com.Lanchonete.LOG.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final LogService logService;

    private final LogRepository logRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, LogService logService, LogRepository logRepository) {
        this.clienteRepository = clienteRepository;
        this.logService = logService;
        this.logRepository = logRepository;
    }

    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        // Se o ID for gerado somente no momento em que armazena no banco, pode ser que aqui o ID ainda seja NULL

        this.validarCliente(cliente);

        cliente.setSaldo(0.0);
        Log log = new Log(cliente.getSaldo());
        cliente.getLogList().add(log);
        cliente =  this.clienteRepository.save(cliente);

        return cliente;
    }

    public Cliente pegarPorId(Integer id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    // Crédito de saldo
    @Transactional
    public Cliente creditarPorId(Integer id) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        double novoSaldo = cliente.getSaldo() + 10;
        cliente.setSaldo(novoSaldo);
        return null;
    }

    // Débito de saldo

    @Transactional
    public Cliente debitarPorId(Integer id, double valor) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        double novoSaldo = cliente.getSaldo() - valor;
        cliente.setSaldo(novoSaldo);
        return null;
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
