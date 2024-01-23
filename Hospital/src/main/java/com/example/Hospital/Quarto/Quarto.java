package com.example.Hospital.Quarto;

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
@Entity(name = "quarto")
public class Quarto extends EntityId {
    @Column(name = "codigo_quarto")
    private String codigoQuarto;

    @Column(name = "status_quarto")
    private boolean statusQuarto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ala_id")
    private List<Ala> alas;
}
