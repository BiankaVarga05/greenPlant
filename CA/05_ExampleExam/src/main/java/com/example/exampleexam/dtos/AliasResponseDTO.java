package com.example.exampleexam.dtos;

public class AliasResponseDTO {
    private Long id;
    private String url;
    private String alias;
    private Integer hitCount;

    public AliasResponseDTO(Long id, String url, String alias, Integer hitCount) {
        this.id = id;
        this.url = url;
        this.alias = alias;
        this.hitCount = hitCount;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getHitCount() {
        return hitCount;
    }
}
