package com.example.testing.services;

import com.example.testing.dtos.CarDTO;
import com.example.testing.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();

    Optional<Car> findById(Long id);

    boolean hasCar(Long id);

    void save(Car car);

    void deleteById(Long id);

    Car modifyCar(Long id, CarDTO car);

    boolean isRequestValid(Long id, CarDTO car);
}
