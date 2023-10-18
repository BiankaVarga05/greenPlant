package com.example.testing;

import com.example.testing.models.Car;
import com.example.testing.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingApplication implements CommandLineRunner {

  private CarRepository carRepository;

  @Autowired
  public TestingApplication(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TestingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    carRepository.save(new Car("Volvo", 2000, "ADH 152"));
  }
}
