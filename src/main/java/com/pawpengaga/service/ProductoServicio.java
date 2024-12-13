package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.Categoria;
import com.pawpengaga.model.Producto;
import com.pawpengaga.repository.CategoriaRepository;
import com.pawpengaga.repository.ProductoRepository;

@Service
public class ProductoServicio {

  @Autowired
  ProductoRepository productoRepo;

  @Autowired
  CategoriaRepository catRepo;

  // Se hace el CRUD normal
  public List<Producto> listarProductos(){
    return productoRepo.findAll(); // La implementacion fue hecha automaticamente por JPA!!
  }

  public Producto obtenerPorId(long id){
    // return productoRepo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado...")); // Podemos elegir entre lanzar una excepcion o un null
    return productoRepo.findById(id).orElse(null);
  }

  public Producto guardar(Producto prodInput, long catId){
    // Se trae el id de la categoria desde el Producto porque fue contruido por completo en la etapa de formulario
    //Categoria cat = catRepo.findById(prodInput.getCategoria().getId()).orElse(null);
    Categoria cat = catRepo.findById(catId).orElse(null);

    // System.out.println(catId);

    if (cat != null) prodInput.setCategoria(cat);
    return productoRepo.save(prodInput);
  }

  public void eliminar(long id){
    productoRepo.deleteById(id);
  }

  /* ********************** Metodos personalizados ********************** */

  public List<Producto> obtenerPorMarca(String marca){
    return productoRepo.findByMarca(marca);
  }

  public List<Producto> obtenerPorModelo(String modelo){
    return productoRepo.busquedaPorModelo(modelo);
  }

  public List<Producto> obtenerPorDescripcion(String filtro){
    return productoRepo.busquedaPorDescripcion(filtro);
  }

}
