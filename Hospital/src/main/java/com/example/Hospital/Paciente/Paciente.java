package com.example.Hospital.Paciente;

import com.example.Hospital.Helpers.EntityId;
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
@Entity(name = "paciente")
public class Paciente extends EntityId {
    @Column(name = "paciente")
    private String nomePaciente;
}
