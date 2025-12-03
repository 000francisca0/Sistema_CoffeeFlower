package com.example.Productos.controller;

import com.example.Productos.model.Producto;
import com.example.Productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        return repository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoDetalles.getNombre());
                    producto.setDescripcion(productoDetalles.getDescripcion());
                    producto.setPrecio(productoDetalles.getPrecio());
                    producto.setStock(productoDetalles.getStock());
                    producto.setCategoria(productoDetalles.getCategoria());
                    producto.setImagenUrl(productoDetalles.getImagenUrl());
                    return ResponseEntity.ok(repository.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}