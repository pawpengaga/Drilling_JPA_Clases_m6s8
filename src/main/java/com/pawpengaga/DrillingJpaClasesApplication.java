package com.pawpengaga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pawpengaga.model.Categoria;
import com.pawpengaga.model.Producto;
import com.pawpengaga.service.CategoriaServicio;
import com.pawpengaga.service.ProductoServicio;

@SpringBootApplication
public class DrillingJpaClasesApplication implements CommandLineRunner {

	@Autowired
	ProductoServicio prodService;

	@Autowired
	CategoriaServicio catService;

	public static void main(String[] args) {
		SpringApplication.run(DrillingJpaClasesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Categoria cat1 = new Categoria();
		// cat1.setNombre("Electronicos");

		// catService.crearCategoria(cat1);

		// Producto prod1 = new Producto();
		// prod1.setDescripcion("Un producto creado por medio de CommandLineRunner");
		// prod1.setMarca("TOSHIBA");
		// prod1.setModelo("H1");
		// prod1.setStock(32);
		
		// prodService.guardar(prod1, 1);

		List<Producto> productos = prodService.listarProductos();

		for (Producto producto : productos) {
			System.out.println("{ Id: " + producto.getId() + ", Descripcion: " + producto.getDescripcion() + ", Marca: " + producto.getMarca() + ", Modelo: " + producto.getModelo() + ", Stock: " + producto.getStock() + ", Categoria: " + producto.getCategoria().getNombre() + " }");
		}

	}

}
