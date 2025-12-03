package Microservicio.Ventas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Microservicio.Ventas.Repository.SaleRepository;
import Microservicio.Ventas.model.Sale;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @GetMapping
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return saleRepository.save(sale);
    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleRepository.deleteById(id);
    }
}
