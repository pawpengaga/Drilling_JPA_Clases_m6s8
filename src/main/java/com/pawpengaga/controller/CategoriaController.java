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

import com.pawpengaga.model.Categoria;
import com.pawpengaga.service.CategoriaServicio;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
  CategoriaServicio catService;

  @GetMapping
  public String inicio(Model model){
    List<Categoria> categorias = catService.getAllCategorias();
    model.addAttribute("categorias", categorias);
    return "categorias"; // Esto como siempre llama a categorias.html
  }

  @PostMapping("/add")
  public String guardar(@ModelAttribute Categoria cat /*, @ModelAttribute long catId */){
    catService.crearCategoria(cat);
    return "redirect:/categorias";
  }

  // Eliminar en base al id de forma dinamica!!
  @PostMapping("/eliminar/{id}")
  public String eliminar(@PathVariable long id){ // También se puede hacer como @PathVariable("id")
    catService.eliminarCategoria(id);
    return "redirect:/categorias";
  }

}
