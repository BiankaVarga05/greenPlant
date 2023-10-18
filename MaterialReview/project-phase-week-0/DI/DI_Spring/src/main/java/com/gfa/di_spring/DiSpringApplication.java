package com.gfa.di_spring;

import com.gfa.di_spring.services.CodingService;
import com.gfa.di_spring.services.JavaCodingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiSpringApplication implements CommandLineRunner {
  //private CodingService codingService;

  public DiSpringApplication() {
    //this.codingService = new JavaCodingService();
  }

  public static void main(String[] args) {
    SpringApplication.run(DiSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //codingService.guideApprentices();
  }
}
