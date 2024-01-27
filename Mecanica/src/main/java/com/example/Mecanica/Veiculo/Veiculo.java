package com.example.Mecanica.Veiculo;

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
@Entity(name = "veiculo")
public class Veiculo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "ano_de_fabricacao")
    private int anoDeFabricacao;

    @Column(name = "km_rodados")
    private int kmRodados;

    public Veiculo(String modelo, String marca, int anoDeFabricacao, int kmRodados) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.kmRodados = kmRodados;
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public int getKmRodados() {
        return kmRodados;
    }
}
