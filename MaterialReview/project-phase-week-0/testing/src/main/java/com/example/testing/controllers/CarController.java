package com.example.testing.controllers;

import com.example.testing.dtos.CarDTO;
import com.example.testing.models.Car;
import com.example.testing.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(path = "/car")
    public List<Car> getAllCar() {
        return service.findAll();
    }

    @GetMapping(path = "/car/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Optional<Car> car = service.findById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(path = "/car")
    public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
            service.save(newCar);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity modifyCar(@PathVariable Long id, @RequestBody CarDTO car) {
        if (service.isRequestValid(id, car)) {
            Car storedCar = service.modifyCar(id, car);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(storedCar);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id){
        if (service.hasCar(id)) {
            service.deleteById(id);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
