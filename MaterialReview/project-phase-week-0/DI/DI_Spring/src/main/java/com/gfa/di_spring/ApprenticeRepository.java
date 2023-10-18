package com.gfa.di_spring;

import org.springframework.stereotype.Repository;

@Repository
public class ApprenticeRepository {
  public void saySomething() {
    System.out.println("Hi, I am a repo");
  }
}
