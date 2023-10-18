package com.greenfoxi.webshop;

public class LearnedAnnotation {
  private String name;
  private String annotatedEntity;

  private String description;

  public LearnedAnnotation(String name, String annotatedEntity, String description) {
    this.name = name;
    this.annotatedEntity = annotatedEntity;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getAnnotatedEntity() {
    return annotatedEntity;
  }

  public String getDescription() {
    return description;
  }
}
