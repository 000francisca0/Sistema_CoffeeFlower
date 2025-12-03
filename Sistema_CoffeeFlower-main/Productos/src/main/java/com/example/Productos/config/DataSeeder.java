package com.example.Productos.config;

import com.example.Productos.model.Producto;
import com.example.Productos.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataSeeder(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("---------- CARGANDO DATOS (NOMBRES EN MINÚSCULA) ----------");

            List<Producto> menu = Arrays.asList(
                // ⚠️ CAMBIO IMPORTANTE: Todo en minúsculas para coincidir con 'res/drawable'
                
                new Producto(null, "Capuchino", "Café espresso con leche vaporizada.", 3200.0, 100, "Cafés", "capuchino"),
                new Producto(null, "Mokachino", "Capuchino con chocolate.", 3500.0, 100, "Cafés", "mokachino"),
                new Producto(null, "Latte", "Café con mucha leche.", 3000.0, 100, "Cafés", "latte"),
                new Producto(null, "Americano", "Espresso diluido.", 2200.0, 100, "Cafés", "americano"),
                new Producto(null, "Expresso", "Café puro.", 2000.0, 100, "Cafés", "expresso"),
                new Producto(null, "Cortado", "Café cortado.", 2300.0, 100, "Cafés", "cortado"),
                
                // Fíjate que tus archivos dicen 'pastel_chocolate.jpeg', aquí pones solo el nombre
                new Producto(null, "Pastel Chocolate", "Pastel húmedo.", 3800.0, 50, "Pastelería", "pastel_chocolate"),
                new Producto(null, "Galleta Chips", "Galleta con chispas.", 1800.0, 150, "Dulces", "galleta_chocolate"),
                
                new Producto(null, "Té Matcha", "Té verde ceremonial.", 3900.0, 80, "Té e Infusiones", "te_matcha_latte"),
                new Producto(null, "Té Helado", "Té frío con frambuesa.", 2800.0, 100, "Té e Infusiones", "te_helado_frambuesa")
            );

            repository.saveAll(menu);
            System.out.println("✅ ¡Nombres corregidos cargados!");
        }
    }
}