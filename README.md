# Aplicación de inventario

## Consideraciones

- Hubo un cambio de nombre de categorias a nombre (categorias -> nombre) en algun lado del modelo. Dará problemas a futuro
- En general, hay muchos problemas respecto al nombre del atributo...

## Novedades

- El uso de JPA

## Observaciones

- Se puede dar nombre a los params especificandolos en el decorador

- @ModelAttribute sirve para el objeto directo
- @RequestParam recibe el param que le venga por medio de su nombre de variable desde el formulario

```java
@PathVariable("id")
```

## Investigar

El uso de `@RequestParam`

```java
public String listar(Model model, @RequestParam(required = false) String filtro){
  List<Producto> productos = (filtro == null || filtro.isEmpty()) ? prodService.listarProductos() : prodService.obtenerPorDescripcion(filtro);
  model.addAttribute(filtro, productos);
  return "index";
}
```