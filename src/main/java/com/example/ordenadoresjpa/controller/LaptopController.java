package com.example.ordenadoresjpa.controller;

import com.example.ordenadoresjpa.modelo.Laptop;
import com.example.ordenadoresjpa.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class LaptopController {

    private LaptopRepository laptopRepositoryl;

    public LaptopController(LaptopRepository laptopRepositoryl) {
        this.laptopRepositoryl = laptopRepositoryl;
    }

    //CRUD sobre el modelo

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepositoryl.findAll();
    }
    @GetMapping("/api/laptops/{id}")
    //Buscar laptop por Id

    public ResponseEntity<Laptop> findOne(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepositoryl.findById(id);

        if (laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    //Crear laptop
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if (laptop.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepositoryl.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Actualizar laptop
    @PutMapping ("/api/laptos")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepositoryl.existsById(laptop.getId())) {
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepositoryl.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Eliminar laptop por id
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        laptopRepositoryl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Eliminar lista de laptops
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepositoryl.deleteAll();
        return ResponseEntity.noContent().build();
    }
}



