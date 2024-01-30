package com.Lanchonete.Cliente;

import com.Lanchonete.LOG.Log;
import com.Lanchonete.LOG.LogRepository;
import com.Lanchonete.LOG.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        //armazenar as informações do log na lista de log da Cliente
        //AQUI
        //Log log = new Log(cliente.getSaldo(), cliente.getId());
        Log log = new Log(cliente.getSaldo());
        this.logRepository.save(log);

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
