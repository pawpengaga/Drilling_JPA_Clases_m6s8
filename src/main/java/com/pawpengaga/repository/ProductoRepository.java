package com.pawpengaga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pawpengaga.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

  // JPA no es recomendado para bases de datos no relacionales...
  // Si la base de datos no trae un buen diseño habrán problemas

  // Approach dejandole todo a JPA
  List<Producto> findByMarca(String marca); // Estos metodos son creados automaticamente por convencion

  // Approach usando HQL (Hybernate Query Language)
  @Query("FROM Producto WHERE modelo = :modelo")
  List<Producto> busquedaPorModelo(@Param("modelo") String modelo);

  // Approach usando SQL normalito (Para casos especialmente complicados como retornos de subconsultas)
  @Query("SELECT p FROM Producto p WHERE p.descripcion LIKE %:descripcion%")
  List<Producto> busquedaPorDescripcion(String descripcion);

}
