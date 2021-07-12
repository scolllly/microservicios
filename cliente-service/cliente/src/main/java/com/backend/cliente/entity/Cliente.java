package com.backend.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "cliente")
@AllArgsConstructor @Builder
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellidos;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    private int edad;

    private String ciudad;
  
    
}
