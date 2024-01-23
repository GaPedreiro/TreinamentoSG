package com.example.Hospital.LogInternacoes;

import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Leito.Leito;
import com.example.Hospital.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "log_internacoes")
public class LogInternacoes extends EntityId {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leito_id")
    private List<Leito> leitos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private List<Paciente> pacientes;
    @Column(name = "data_internamento")
    private Date dataInternamento;

    @Column(name = "data_alta")
    private Date dataAlta;
}
