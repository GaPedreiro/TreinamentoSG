package com.Lanchonete.LOG;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "log")
public class Log {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "saldo")
    private double saldoCliente;

    public Log(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Integer getId() {
        return id;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }
}
