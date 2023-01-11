package com.example.ordenadoresjpa.repository;

import com.example.ordenadoresjpa.modelo.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LaptopRepository extends JpaRepository <Laptop, Long> {

    void save();

    void deleteById(Long id);
}
