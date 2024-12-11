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

import com.pawpengaga.model.Producto;
import com.pawpengaga.service.ProductoServicio;

@Controller
@RequestMapping("/")
public class ProductoController {

  // Inyectamos el servicio
  @Autowired
  ProductoServicio prodService;

  // Para busquedas
  @GetMapping
  public String listar(Model model, @RequestParam(required = false) String filtro){
    List<Producto> productos = (filtro == null || filtro.isEmpty()) ? prodService.listarProductos() : prodService.obtenerPorDescripcion(filtro);
    model.addAttribute(filtro, productos);
    return "index";
  }

  @PostMapping("/add")
  public String guardar(@ModelAttribute Producto prod){
    prodService.guardar(prod);
    return "redirect:/";
  }

  // Eliminar en base al id de forma dinamica!!
  @PostMapping("/eliminar/{id}")
  public String eliminar(@PathVariable long id){ // También se puede hacer como @PathVariable("id")
    prodService.eliminar(id);
    return "redirect:/";
  }

}
