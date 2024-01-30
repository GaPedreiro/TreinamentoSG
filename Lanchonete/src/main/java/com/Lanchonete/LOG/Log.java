package com.Lanchonete.LOG;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

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

    //@Column(name = "pessoa_id")
    //private Integer pessoaId;

    /* AQUI
    public Log(double saldoCliente, Integer pessoaId) {
        this.saldoCliente = saldoCliente;
        this.pessoaId = pessoaId;
    }
     */

    public Log(double saldoCliente) {
        this.saldoCliente = saldoCliente;

    }

    public Integer getId() {
        return id;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    /* AQUI
    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

     */
}
