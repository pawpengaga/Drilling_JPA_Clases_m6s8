package com.pawpengaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawpengaga.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

  // Cosas como la busqueda por id ya vienen dadas por JPA

  Categoria findByCategoria(String categoria);

}
