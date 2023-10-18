package com.example.exampleexam.controllers;

import com.example.exampleexam.dtos.AliasRequestDTO;
import com.example.exampleexam.dtos.AliasResponseDTO;
import com.example.exampleexam.dtos.SecretCode;
import com.example.exampleexam.models.Alias;
import com.example.exampleexam.models.ErrorMessage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AliasController {
    @PersistenceContext
    private EntityManager entityManager;

    public AliasController(){}

    @Transactional
    @PostMapping(path = "/api/links")
    public ResponseEntity<?> addAlias(@RequestBody AliasRequestDTO aliasRequestDTO){
        if(aliasRequestDTO.getAlias() == null || aliasRequestDTO.getUrl() == null){
            ErrorMessage errorMessage = new ErrorMessage("No alias or URL provided!");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        Query query = entityManager.createNativeQuery("SELECT * FROM aliases WHERE alias = '" + aliasRequestDTO.getAlias() + "'", Alias.class);
        if(query.getResultList().size() != 0){
            ErrorMessage errorMessage = new ErrorMessage("Alias alread exists!");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        Alias alias = new Alias(aliasRequestDTO.getUrl(), aliasRequestDTO.getAlias());
        entityManager.persist(alias);
        return new ResponseEntity<>(alias, HttpStatus.OK);
    }

    @Transactional
    @GetMapping(path = "/a/{alias}")
    public ResponseEntity<?> incrementHitCount(@PathVariable String alias){
        Query query = entityManager.createNativeQuery("SELECT * FROM aliases WHERE alias = '" + alias + "'", Alias.class);
        List<Alias> aliases = query.getResultList();
        if(aliases.size() == 0){
            ErrorMessage errorMessage = new ErrorMessage("Alias does not exist!");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

        Alias aliasToIncrement = aliases.get(0);
        aliasToIncrement.setHitCount(aliasToIncrement.getHitCount() + 1);
        entityManager.persist(aliasToIncrement);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(aliasToIncrement.getUrl()));
        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @GetMapping(path = "/api/links")
    public ResponseEntity<List<AliasResponseDTO>> getAlises(){
        Query query = entityManager.createNativeQuery("SELECT * FROM aliases", Alias.class);
        List<Alias> alises = query.getResultList();
        List<AliasResponseDTO> aliasesWithoutSecretCode = new ArrayList<>();
        for (Alias alias : alises){
            AliasResponseDTO aliasWithoutSecretCode = new AliasResponseDTO(alias.getId(), alias.getUrl(), alias.getAlias(), alias.getHitCount());
            aliasesWithoutSecretCode.add(aliasWithoutSecretCode);
        }
        return new ResponseEntity<>(aliasesWithoutSecretCode, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/api/links/{id}")
    public ResponseEntity<?> deleteAlias(@PathVariable Long id, @RequestBody SecretCode secretCode){
        if(secretCode.getSecretCode() == null){
            ErrorMessage errorMessage = new ErrorMessage("No secret code provided!");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

        Alias alias = entityManager.find(Alias.class, id);
        if(alias == null){
            ErrorMessage errorMessage = new ErrorMessage("No alias with the given id!");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

        if(!alias.getSecretCode()
                .equals(secretCode.getSecretCode())){
            ErrorMessage errorMessage = new ErrorMessage("Secret codes does not match!");
            return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
        }

        entityManager.remove(alias);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
