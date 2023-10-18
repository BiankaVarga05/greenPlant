package com.gfa.springdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
  @RequestMapping(path = "/welcomelaci", method = RequestMethod.GET)
  public String sayHelloToLaci(@RequestParam(required = false) String how, @RequestParam String when){
    return "Laci, megy ez: " + how + " " + when;
  }
}
