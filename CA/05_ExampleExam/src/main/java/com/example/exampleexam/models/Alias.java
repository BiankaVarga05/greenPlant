package com.example.exampleexam.models;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "aliases")
public class Alias {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String url;
    private String alias;
    private Integer hitCount;
    private String secretCode;

    public Alias() {
    }

    public Alias(String url, String  alias){
        this.url = url;
        this.alias = alias;
        this.hitCount = 0;
        this.secretCode = generateSecretCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    private String generateSecretCode(){
        String secretCode = "";
        for (int i = 0; i < 4; i++){
            Random rand = new Random();
            int randomDigit = rand.nextInt(10);
            secretCode += String.valueOf(randomDigit);
        }

        return secretCode;
    }
}
