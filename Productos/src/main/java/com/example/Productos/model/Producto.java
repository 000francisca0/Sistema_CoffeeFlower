package com.example.Productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @Column(length = 500)
    private String descripcion;
    
    private Double precio;
    private Integer stock;
    private String categoria;
    
    @Column(length = 1000)
    private String imagenUrl;
}