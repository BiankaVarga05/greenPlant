package com.example.testing.integration;

import com.example.testing.models.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {


  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper mapper = new ObjectMapper();

  @Test
  public void getCarById_WithExistingCar_Returnscar() throws Exception {
    mockMvc.perform(get("/car/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.brand", is("Volvo")))
      .andExpect(jsonPath("$.year", is(2000)));
  }

  @Test
  public void getCarById_WithNonExistingCar_ReturnsNone() throws Exception {
    mockMvc.perform(get("/car/100000"))
      .andExpect(status().isNotFound());
  }


  @Test
  public void createCar_WithValidData_ReturnsUpdatedCar() throws Exception {
    Car newCar = new Car("BMW", 2021, "GFA-001");
    String carAsString = mapper.writeValueAsString(newCar);
    mockMvc.perform(post("/car")
        .contentType(MediaType.APPLICATION_JSON)
        .content(carAsString))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id", is(2)))
      .andExpect(jsonPath("$.year", is(newCar.getYear())))
      .andExpect(jsonPath("$.brand", is(newCar.getBrand())))
      .andExpect(jsonPath("$.registrationMark", is(newCar.getRegistrationMark())));
    ;
  }
}
