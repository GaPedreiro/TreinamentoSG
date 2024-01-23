package com.example.Hospital.Leito;

import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Paciente.Paciente;
import com.example.Hospital.Quarto.Quarto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name  = "leito")
public class Leito extends EntityId {
    @Column(name = "codigo_leito")
    private String codigoLeito;

    @Column(name = "statusLeito")
    private boolean statusLeito;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarto_id")
    private List<Quarto> quartos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private List<Paciente> pacientes;
}
