package com.example.testing.unit;

import com.example.testing.dtos.CarDTO;
import com.example.testing.models.Car;
import com.example.testing.repositories.CarRepository;
import com.example.testing.services.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CarServiceImpTest {

  // With manual mocking
  @Test
  public void isRequestValid_WithValidRequest_ReturnsTrue_A(){
    // Arrange
    CarDTO car = new CarDTO();
    car.setBrand("Volvo");
    car.setYear(2);
    CarServiceImpl carService = new CarServiceImpl(new FakeCarRepository());

    // Act
    boolean isValid = carService.isRequestValid(1L, car);

    // Assert
    Assertions.assertTrue(isValid);
  }

  // With manual mocking
  @Test
  public void isRequestValid_WithValidRequest_ReturnsTrue_B(){
    // Arrange
    CarDTO car = new CarDTO();
    car.setBrand("Volvo");
    car.setYear(2);
    CarRepository carRepository = Mockito.mock(CarRepository.class);
    Mockito.when(carRepository.findById(1L)).thenReturn(Optional.of(new Car()));
    CarServiceImpl carService = new CarServiceImpl(carRepository);

    // Act
    boolean isValid = carService.isRequestValid(1L, car);

    // Assert
    Assertions.assertTrue(isValid);
  }


  @Test
  public void isRequestValid_WithInvalidRequest_ReturnsFalse(){
    // Arrange
    CarDTO car = new CarDTO();
    CarServiceImpl carService = new CarServiceImpl(new FakeCarRepository());

    // Act
    boolean isValid = carService.isRequestValid(1L, car);

    // Assert
    Assertions.assertFalse(isValid);
  }
}

class FakeCarRepository implements CarRepository {

  @Override
  public void flush() {

  }

  @Override
  public <S extends Car> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Car> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<Car> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Car getOne(Long aLong) {
    return null;
  }

  @Override
  public Car getById(Long aLong) {
    return null;
  }

  @Override
  public Car getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends Car> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Car> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Car> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Car> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Car> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Car, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends Car> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Car> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Car> findById(Long aLong) {
    return Optional.of(new Car());
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public List<Car> findAll() {
    return null;
  }

  @Override
  public List<Car> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(Car entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Car> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Car> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Car> findAll(Pageable pageable) {
    return null;
  }
}
