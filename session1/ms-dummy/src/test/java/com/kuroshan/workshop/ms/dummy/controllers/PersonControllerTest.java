package com.kuroshan.workshop.ms.dummy.controllers;

import com.kuroshan.workshop.ms.dummy.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("Register people Test")
  public void registerPeopleTest() throws Exception {

    Person person = Person
        .builder()
        .firstName("Elvis")
        .lastName("Argume")
        .age(32)
        .typeDocument("dni")
        .idDocument("123456789")
        .build();

    ResponseEntity<Person> response = restTemplate.postForEntity("/persons", person, Person.class);
    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

  }

}
