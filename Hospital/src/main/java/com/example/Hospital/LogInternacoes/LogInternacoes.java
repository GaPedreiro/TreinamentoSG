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
public class LogInternacoes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "leito_id")
    private Integer leitoId;

    @Column(name = "paciente_id")
    private Integer pacienteId;
    @Column(name = "data_internamento")
    private Date dataInternamento;

    @Column(name = "data_alta")
    private Date dataAlta;
}
