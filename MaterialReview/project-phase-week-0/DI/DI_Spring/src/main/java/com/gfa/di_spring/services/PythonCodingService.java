package com.gfa.di_spring.services;

import com.gfa.di_spring.ApprenticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PythonService")
public class PythonCodingService implements CodingService{

  private ApprenticeRepository apprenticeRepository;

  @Autowired
  public PythonCodingService(ApprenticeRepository apprenticeRepository) {
    this.apprenticeRepository = apprenticeRepository;
  }

  public void guideApprentices(){
    apprenticeRepository.saySomething();
    System.out.println("We are guiding you through the dangerous forests of Python");
  }
}
