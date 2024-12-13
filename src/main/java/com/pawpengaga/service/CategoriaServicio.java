package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.Categoria;
import com.pawpengaga.repository.CategoriaRepository;

@Service
public class CategoriaServicio {

  @Autowired
  CategoriaRepository catRepo;

  public Categoria crearCategoria(Categoria c){
    return catRepo.save(c);
  }

  public Categoria obtenerCategoria(long id){
    return catRepo.findById(id).orElse(null);
  }

  public List<Categoria> getAllCategorias(){
    return catRepo.findAll();
  }

  public void eliminarCategoria(long id){
    catRepo.deleteById(id);
  }

  /* ************************ METODOS PROPIOS ************************ */

  public Categoria getCategoriaPorNombre(String cat){
    return catRepo.findByNombre(cat);
  }

}
