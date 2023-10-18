package com.gfa.springsql.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gazdis")
public class Gazdi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String gazdiName;

  @ManyToMany (cascade = CascadeType.PERSIST, mappedBy = "gazdis" ,fetch = FetchType.EAGER)
  private List<Nyuszi> nyuszis;

  public Gazdi() {
    nyuszis = new ArrayList<>();
  }

  public Gazdi(String gazdiName, Nyuszi nyuszi) {
    this();
    this.gazdiName = gazdiName;
    this.nyuszis.add(nyuszi);
    nyuszi.addGazdi(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGazdiName() {
    return gazdiName;
  }

  public void setGazdiName(String gazdiName) {
    this.gazdiName = gazdiName;
  }

  public List<Nyuszi> getNyuszis() {
    return nyuszis;
  }

  public void addNyuszi(Nyuszi nyuszi) {
    this.nyuszis.add(nyuszi);
    nyuszi.addGazdi(this);
  }

  //endregion
}
