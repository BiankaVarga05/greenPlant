package com.gfa.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyFirstController {

  // Functions become endpoints when they are in
  // classes marked with @Controller or @RestController
  // and when the functions are marked with @RequestMapping
  // or its shorter versions
  @ResponseBody
  //@RequestMapping(path = "/welcome", method = RequestMethod.GET)
  @GetMapping(path = "/welcome")
  public String sayHelloToLeo(){
    return "Leo, ezzel itt, az endpointon keresztül hívható meg";
  }

  @RequestMapping(path = "/something", method = RequestMethod.GET)
  public String sayHelloToLaci(Model model){
    model.addAttribute("keyToData", "ezt ird ki");
    return "Elcica";
  }
}
