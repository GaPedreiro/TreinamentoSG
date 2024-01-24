package com.example.Hospital.Hospital;

import com.example.Hospital.Ala.Ala;
import com.example.Hospital.Helpers.EntityId;
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
@Entity(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "hospital_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nomeHospital;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ala_id")
    private List<Ala> alas;
}