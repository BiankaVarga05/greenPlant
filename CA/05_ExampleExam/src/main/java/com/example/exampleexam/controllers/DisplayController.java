package com.example.exampleexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {
    @GetMapping(path = "/")
    public String displayIndex(){
        return "index";
    }

}
