package com.example.Hospital.Ala;

import com.example.Hospital.Helpers.EntityId;
import com.example.Hospital.Hospital.Hospital;
import com.example.Hospital.HospitalApplication;
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
public class Ala extends EntityId {

    @Column(name = "especialidade")
    private String especialidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private List<Hospital> hospitais;
}
