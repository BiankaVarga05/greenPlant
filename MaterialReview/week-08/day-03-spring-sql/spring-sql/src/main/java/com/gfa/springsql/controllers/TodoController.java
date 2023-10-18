package com.gfa.springsql.controllers;

import com.gfa.springsql.models.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

  @PersistenceContext
  private EntityManager entityManager;

  public TodoController() {
  }

  @RequestMapping (path = "/todos", method = RequestMethod.GET)
  public ResponseEntity<List<Todo>> getTodos () {
    Query query = entityManager.createNativeQuery("SELECT * FROM todo", Todo.class);
    List<Todo> todos = query.getResultList();
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @Transactional
  @RequestMapping (path = "/todo", method = RequestMethod.POST)
  public ResponseEntity<Todo> addTodo (@RequestBody Todo todo) {
    entityManager.persist(todo);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @Transactional
  @RequestMapping(path = {"/todo/{id}"}, method = RequestMethod.PUT)
  public ResponseEntity<?> editTodo(@PathVariable long id, @RequestBody Todo todoData) {
    Todo todo = entityManager.find(Todo.class, id);
    if (todo == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    todo.setDone(todoData.getDone());
    todo.setTitle(todoData.getTitle());
    todo.setUrgent(todoData.getUrgent());
    entityManager.persist(todo);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }
}
