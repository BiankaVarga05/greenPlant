package com.greenfoxi.webshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebshopController {

  private List<LearnedAnnotation> annotations = new ArrayList<>();

  public WebshopController() {
    annotations.add(new LearnedAnnotation("@Controller", "class", "make the class a controller"));
    annotations.add(new LearnedAnnotation("@RestController", "class", "make the class a REST controller"));
    annotations.add(new LearnedAnnotation("@RequestMapping", "method", "declares the method as endpoint with the given path and method"));
    annotations.add(new LearnedAnnotation("@RequestParam", "method parameter", "read data from Query Parameter"));
  }

  @RequestMapping(path = "/annotations", method = RequestMethod.GET)
  public String listAllAnnotations(Model model){
    model.addAttribute("annotations", annotations);
    return "webshop";
  }

  @RequestMapping(path = "/annotations", method = RequestMethod.POST)
  public String listFilteredAnnotations(Model model, @ModelAttribute (name = "data-sent") String dataSent){
    if (dataSent.equals("")){
      model.addAttribute("annotations", annotations);
    } else {
      List<LearnedAnnotation> filetered = new ArrayList<>();
      for (LearnedAnnotation annotation: annotations) {
        if (annotation.getAnnotatedEntity().equals(dataSent)) {
          filetered.add(annotation);
        }
      }
      model.addAttribute("annotations", filetered);
    }

    return "webshop";
  }
}
