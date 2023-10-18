package com.gfa.springsql;

import com.gfa.springsql.models.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSqlApplication implements CommandLineRunner {

  @PersistenceContext
  private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringSqlApplication.class, args);
	}

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    entityManager.persist(new Todo("Understand JPA", true, false));
    entityManager.persist(new Todo("Understand Annotations", true, false));
    entityManager.persist(new Todo("Understand SQL", true, true));
    entityManager.persist(new Todo("Feed the cat", false, false));
  }
}
