package com.example.springbatch.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class OutProfesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RUT")
    private String rut;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name="ESPECIALIDAD")
    private String especialidad;
}
