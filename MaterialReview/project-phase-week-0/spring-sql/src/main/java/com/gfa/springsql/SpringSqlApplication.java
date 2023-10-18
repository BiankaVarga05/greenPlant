package com.gfa.springsql;

import com.gfa.springsql.models.Gazdi;
import com.gfa.springsql.models.Nyuszi;
import com.gfa.springsql.repositories.GazdiRepository;
import com.gfa.springsql.repositories.NyusziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSqlApplication implements CommandLineRunner {


  private GazdiRepository gazdiRepository;
  private NyusziRepository nyusziRepository;

  @Autowired
  public SpringSqlApplication(GazdiRepository gazdiRepository, NyusziRepository nyusziRepository) {
    this.gazdiRepository = gazdiRepository;
    this.nyusziRepository = nyusziRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringSqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Nyuszi chili = new Nyuszi("Chili", 4);
    Nyuszi licsi = new Nyuszi("Licsi", 4);
    Gazdi szandra = new Gazdi("Szandra", chili);
    Gazdi agoston = new Gazdi("Agoston", chili);
    szandra.addNyuszi(licsi);
    gazdiRepository.save(szandra);
    gazdiRepository.save(agoston);


    Gazdi szandraFromRepo = gazdiRepository.findById(1L).get();
    Nyuszi nyuszko = szandraFromRepo.getNyuszis().get(1);
    Nyuszi chiliFromRepo = nyusziRepository.findById(1L).get();
  }
}
