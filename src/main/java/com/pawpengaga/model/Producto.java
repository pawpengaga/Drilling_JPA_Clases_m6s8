package com.pawpengaga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  
  @Column(name = "marca",nullable = false)
  private String marca; // Es NOT NULL
  
  @Column(name = "modelo",nullable = false)
  private String modelo;
  
  @Column(name = "descripcion",nullable = false)
  private String descripcion;
  
  @Column(name = "stock",nullable = false)
  private int stock;

  /* AQUI FUERON OMITIDAS COSAS POR SIMPLICIDAD */

  @ManyToOne
  @JoinColumn(name = "categoria_id", nullable = false, updatable = true) // Vigila la integridad referencial
  private Categoria categoria;

}
