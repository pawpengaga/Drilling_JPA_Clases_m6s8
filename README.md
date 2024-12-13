# Aplicación de inventario

## Consideraciones

- Hubo un cambio de nombre de categorias a nombre (categorias -> nombre) en algun lado del modelo. Dará problemas a futuro

## Novedades

- El uso de JPA

## Observaciones

- Se puede dar nombre a los params especificandolos en el decorador

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