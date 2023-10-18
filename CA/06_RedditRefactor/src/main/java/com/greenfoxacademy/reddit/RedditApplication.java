package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;


    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        postRepository.save(new Post("Zöld foxi", "https://gfa.com"));
        postRepository.save(new Post("KD", "https://kapcsolatdinamika.hu"));
        postRepository.save(new Post("Idokep", "https://idokep.hu"));
    }
}
