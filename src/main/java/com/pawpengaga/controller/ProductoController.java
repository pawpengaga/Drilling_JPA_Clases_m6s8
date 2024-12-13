package com.pawpengaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawpengaga.model.Categoria;
import com.pawpengaga.model.Producto;
import com.pawpengaga.service.CategoriaServicio;
import com.pawpengaga.service.ProductoServicio;

@Controller
@RequestMapping("/")
public class ProductoController {

  // Inyectamos el servicio
  @Autowired
  ProductoServicio prodService;

  @Autowired
  CategoriaServicio catService;

  // Para busquedas
  @GetMapping
  public String listar(Model model, @RequestParam(required = false) String filtro){
    List<Producto> productos = (filtro == null || filtro.isEmpty()) ? prodService.listarProductos() : prodService.obtenerPorDescripcion(filtro);
    List<Categoria> categorias = catService.getAllCategorias();
    model.addAttribute("categorias", categorias);
    model.addAttribute("productos", productos);
    return "productos";
  }

  @PostMapping("/add")
  public String guardar(@ModelAttribute Producto prod, @RequestParam Long cat_id){ // El nombre de esta variable tiene que se exactamente igual a lo que hay en name del formulario
    prodService.guardar(prod, cat_id);
    return "redirect:/productos";
  }

  // Eliminar en base al id de forma dinamica!!
  @PostMapping("/eliminar/{id}")
  public String eliminar(@PathVariable long id){ // También se puede hacer como @PathVariable("id")
    prodService.eliminar(id);
    return "redirect:/productos";
  }

}
