package com.gfa.di_spring.services;


import com.gfa.di_spring.ApprenticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaCodingService implements CodingService {

  private ApprenticeRepository apprenticeRepository;

  @Autowired
  public JavaCodingService(ApprenticeRepository apprenticeRepository) {
    this.apprenticeRepository = apprenticeRepository;
  }

  public void guideApprentices(){
    System.out.println("We are guiding you through the lovely fields ov Java");
    apprenticeRepository.saySomething();
  }
}
