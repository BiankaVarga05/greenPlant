package com.example.testing.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private int year;
  private String registrationMark;
  private boolean valid;

  public Car () {
  }

  public Car(String brand, int year, String registrationMark) {
    this.brand = brand;
    this.year = year;
    this.registrationMark = registrationMark;
    valid = validate();
  }

  //region getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getRegistrationMark() {
    return registrationMark;
  }

  public void setRegistrationMark(String registrationMark) {
    this.registrationMark = registrationMark;
    valid = validate();
  }

  public boolean getValid (){
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
  //endregion

  public boolean validate(){
    // ABC123
    return registrationMark.length() == 6 &&
        Character.isAlphabetic(registrationMark.charAt(0))
        && Character.isAlphabetic(registrationMark.charAt(1))
        && Character.isAlphabetic(registrationMark.charAt(2))
        && Character.isDigit(registrationMark.charAt(3))
        && Character.isDigit(registrationMark.charAt(4))
        && Character.isDigit(registrationMark.charAt(5));
  }
}
