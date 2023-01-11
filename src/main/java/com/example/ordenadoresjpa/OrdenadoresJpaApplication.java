package com.example.ordenadoresjpa;

import com.example.ordenadoresjpa.modelo.Laptop;
import com.example.ordenadoresjpa.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrdenadoresJpaApplication {

	public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(OrdenadoresJpaApplication.class, args);
	LaptopRepository repository = context.getBean(LaptopRepository.class, args);

	repository.save(new Laptop(null, "Azul",2025));
	repository.save(new Laptop(null, "Rojo",2010));
	repository.save(new Laptop(null, "Blanco",2015));
	repository.save(new Laptop(null, "Plateado",2023));


	}

}
