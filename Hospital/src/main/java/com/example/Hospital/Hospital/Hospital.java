package com.example.Hospital.Hospital;

import com.example.Hospital.Ala.Ala;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nomeHospital;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private List<Ala> alas;
}