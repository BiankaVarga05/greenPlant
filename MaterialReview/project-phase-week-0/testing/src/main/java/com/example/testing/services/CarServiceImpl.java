package com.example.testing.services;


import com.example.testing.dtos.CarDTO;
import com.example.testing.models.Car;
import com.example.testing.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean hasCar(Long id) {
        return repository.findById(id).isPresent();
    }

    @Override
    public void save(Car car) {
        repository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Car modifyCar(Long id, CarDTO car) {
        Car storedCar = findById(id).get();
        storedCar.setBrand(car.getBrand());
        storedCar.setYear(car.getYear());
        save(storedCar);
        return storedCar;
    }

    @Override
    public boolean isRequestValid(Long id, CarDTO car) {
        return hasCar(id) &&
          car!=null
          && car.getBrand() != null
          && !car.getBrand().isEmpty()
          && car.getYear() > 0;
    }
}
