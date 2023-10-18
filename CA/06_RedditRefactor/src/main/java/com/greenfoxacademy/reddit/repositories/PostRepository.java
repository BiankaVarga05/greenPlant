package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository <Post, Long > {

    @Query(value = "SELECT * FROM posts LIMIT ?1, ?2", nativeQuery = true)
    List<Post> findByPageAndSize(Long page, Long size);
}
