# Aplicación de inventario

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