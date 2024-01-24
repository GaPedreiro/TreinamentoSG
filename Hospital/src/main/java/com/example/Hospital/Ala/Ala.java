package com.example.Hospital.Ala;

import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Hospital.Hospital;
import com.example.Hospital.HospitalApplication;
import com.example.Hospital.Quarto.Quarto;
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
@Entity(name = "ala")
public class Ala {
    @Id
    @Column(name = "ala_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "especialidade")
    private String especialidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarto_id")
    private List<Quarto> quartos;
}
