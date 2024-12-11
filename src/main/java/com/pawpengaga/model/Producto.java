package com.pawpengaga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // Este objeto se volvera la estructura para una tabla
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id; // Para crear un id PRIMARY KEY SERIAL
  
  @Column(nullable = false)
  private String marca; // Es NOT NULL
  
  @Column(nullable = false)
  private String modelo;
  
  @Column(nullable = false)
  private String descripcion;
  
  @Column(nullable = false)
  private int stock;

}