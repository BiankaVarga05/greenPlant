package com.gfa.di_spring;


import com.gfa.di_spring.services.CodingService;
import com.gfa.di_spring.services.JavaCodingService;
import com.gfa.di_spring.services.PythonCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

  private CodingService codingService;

  @Autowired
  public LanguageController(@Qualifier(value = "PythonService") CodingService codingService) {
    this.codingService = codingService;
  }

  @RequestMapping (path = "/", method = RequestMethod.GET)
  public String displayHi(){
    codingService.guideApprentices();
    return "Hi";
  }
}
