package com.example.Hospital.Leito;

import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Paciente.Paciente;
import com.example.Hospital.Quarto.Quarto;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name  = "leito")
public class Leito {
    @Id
    @Column(name = "leito_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "codigo_leito")
    private String codigoLeito;

    @Column(name = "status_leito")
    private boolean statusLeito;

    @Column(name = "paciente_id")
    private Integer pacienteId;
}
