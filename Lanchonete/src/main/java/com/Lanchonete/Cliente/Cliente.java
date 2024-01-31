package com.Lanchonete.Cliente;

import com.Lanchonete.LOG.ClienteLOG.Log;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "saldo")
    private double saldo;

    // RESOLVER ISSO AQUI COM UM DTO, na situação atual, caso seja feito uma pesquisa por um cliente, devido ao cascade, os logs gerados por aquele cliente virão junto na pesquisa.
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Log> logList = new ArrayList<>();

    public Cliente(String nome, String cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditaSaldo(double valor) {
        this.saldo += valor;
    }

    public void debitaSaldo(double valor) {
        this.saldo -= valor;
    }
}
