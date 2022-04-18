package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct	// it will run before the main method
	public void dataInit() {

		Car c1 = new Car("BMW", "M5");
		Car c2 = new Car("MERCEDES", "GLA");
		Car c3 = new Car("VW", "PASSAT");

		carRepository.save(c1);
		carRepository.save(c2);
		carRepository.save(c3);

	}

}
