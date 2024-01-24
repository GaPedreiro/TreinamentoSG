package com.example.Hospital.Paciente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "paciente")
public class Paciente {
    @Id
    @Column(name = "paciente_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaciente;

    @Column(name = "nome_paciente")
    private String nomePaciente;

}
