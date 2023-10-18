package com.gfa.backendapi.models;

public class Car {
  private int id;
  private String brand;
  private int year;
  private String registrationMark;
  private boolean valid;

  public Car() {
    System.out.println();
  }

  public Car(int id, String brand, int year, String registrationMark) {
    this.id = id;
    this.brand = brand;
    this.year = year;
    this.registrationMark = registrationMark;
    valid = validate();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
