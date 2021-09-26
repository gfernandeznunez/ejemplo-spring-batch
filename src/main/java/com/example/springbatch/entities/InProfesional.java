package com.example.springbatch.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class InProfesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RUT")
    private String rut;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name="CORREO")
    private String correo;

    @Column (name="UNIVERSIDAD")
    private String universidad;

    @ManyToOne(cascade = CascadeType.ALL)
    private InEspecialidad especialidad;

}
