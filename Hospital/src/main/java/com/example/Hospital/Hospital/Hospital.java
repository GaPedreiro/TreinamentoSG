package com.example.Hospital.Hospital;

import com.example.Hospital.Helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Hospital extends EntityId {
    @Column(name = "nome")
    private String nomeHospital;
}