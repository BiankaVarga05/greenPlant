package com.gfa.backendapi.controllers;

import com.gfa.backendapi.dtos.CarDTO;
import com.gfa.backendapi.models.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// REST principles
// https://ninenines.eu/docs/en/cowboy/2.6/guide/rest_principles/

/*
https://www.video.classroom.com/w/videoplay?docid=firstday#colorful
  Protocol (or scheme): `https:`
  Host name
  Prefix: `www`
  Domain: `video.classroom.com`
  Subdomain: `video`
  Domain: `classroom`
  Top level domain: `com`
  Path: `w/videoplay/`
  Query: `?`
  Parameters: `docid=firstday`
  Anchor or fragment: `#colorful`
 */


@Controller
public class CarController {

  private List<Car> cars = new ArrayList<>();

  public CarController() {
    cars.add(new Car(2, "Volvo", 2018, "BT287"));
    cars.add(new Car(4, "Trabi", 1960, "BT2187"));
    cars.add(new Car(8, "Suzuki", 2004, "BTZ284"));
    cars.add(new Car(11, "Tesla", 2023, "CBT787"));
  }


  @GetMapping (path="/")
  public String displayIndex(){
    return "index";
  }

  // REST --> endpoints' path's shall point to resources

  // 1. Get all items at "/car"
  // With all the information available
  @ResponseBody
  @GetMapping (path="/car")
  public List<Car> getCars(){
    return cars;
  }


  // 2. Get item at "/item/{id}"
  // Return car and status 200
  // Or set response code to HttpStatus.NOT_FOUND if does not exist
  @ResponseBody
  @GetMapping (path="/item/{id}")
  public ResponseEntity<?> getCarById(@PathVariable int id){
    for (Car car: cars) {
      if (car.getId() == id){
        return ResponseEntity.status(HttpStatus.OK).body(car);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  // 3. Add new item at "/car/"
  // defined entirely by a JSON object in the body
  // If item with the same id exists: return code 304 (Not modified)
  // Return also 304 when any of the input parameters are invalid
  // Otherwise return with 201 status code (Created)
  // Return the new item
  @ResponseBody
  @PostMapping(path="/car")
  public ResponseEntity<?> addNewCar(@RequestBody Car newCar){
    if (newCar.getId() < 0 || newCar.getBrand() == null ||
      newCar.getBrand() == "" || newCar.getYear() <= 1500 ||
      newCar.getRegistrationMark() == null || newCar.getRegistrationMark() == ""){
      return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    for (Car car : cars) {
      if (car.getId() == newCar.getId()){
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
      }
    }

    cars.add(newCar);
    return new ResponseEntity<>(newCar, HttpStatus.CREATED);
  }


  // 4. Modify item at "/car/id"
  // selected by id via path variable
  // The new data shall be read from the body of the request.
  // Brand and Year data comes in the JSON
  // If the id exits and all input data is valid, return status code 202 (Accepted)
  // Otherwise return status code 304 (Not modified) and the modified car

  @PutMapping(path="/car/{id}")
  @ResponseBody
  public ResponseEntity<?> modifyCarById(@PathVariable int id, @RequestBody CarDTO editedCarData){
    if (editedCarData.getBrand() == null ||
      editedCarData.getBrand() == "" || editedCarData.getYear() <= 1500){
      return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    for (Car car : cars) {
      if (car.getId() == id){
        car.setBrand(editedCarData.getBrand());
        car.setYear(editedCarData.getYear());
        return new ResponseEntity<>(car, HttpStatus.ACCEPTED);
      }
    }

    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
  }



  // 5. Delete item at "/car/id"
  // defined by path variable
  // If the id exits, return status code 202 (Accepted)
  // Otherwise return status NOT FOUND
}
