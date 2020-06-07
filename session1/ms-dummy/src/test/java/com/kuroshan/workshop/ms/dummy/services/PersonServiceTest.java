package com.kuroshan.workshop.ms.dummy.services;

import com.kuroshan.workshop.ms.dummy.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PersonServiceTest {

  @Autowired
  private PersonService personService;

  @Test
  @DisplayName("Create Person Test ")
  void createPersonTest() {
    Person person = Person
        .builder()
        .id(2L)
        .firstName("Elvis")
        .lastName("Argume")
        .age(32)
        .typeDocument("dni")
        .idDocument("123456789")
        .build();

    Assertions.assertEquals(person, personService.createPerson(Person
        .builder()
        .firstName("Elvis")
        .lastName("Argume")
        .age(32)
        .typeDocument("dni")
        .idDocument("123456789")
        .build()));
  }

  @Test
  @DisplayName("Find All People Test")
  void findAllPeopleTest() {
    personService.findAllPeople();
    Assertions.assertTrue(personService.findAllPeople() instanceof List);
  }

  @Test
  @DisplayName("Find by id Person Test")
  void findByIdPersonTest() {
    Assertions.assertTrue(personService.findByIdPerson(2L)!=null);
  }

  @Test
  @DisplayName("Update person Test")
  void updatePersonTest() {
    Person person = Person
        .builder()
        .id(2L)
        .firstName("Elvis")
        .lastName("Argume")
        .age(32)
        .typeDocument("dni")
        .idDocument("123456789")
        .build();
    Assertions.assertTrue(personService.updatePerson(person)!=null);
  }

}
