package com.gfa.springsql.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nyuszis")
public class Nyuszi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int age;

  @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.DETACH})
  //@JoinColumn(name = "xy")
  private List<Gazdi> gazdis;


  public Nyuszi() {
    gazdis = new ArrayList<>();
  }

  public Nyuszi(String name, int age){
    this();
    this.name = name;
    this.age = age;
  }

  //region getters & setters
  public String getName() {
    return name;
  }


  public void addGazdi (Gazdi gazdi){
    gazdis.add(gazdi);
  }
  //endregion

  @Override
  public String toString() {
    return "Hi, I am " + name + " student";
  }
}
