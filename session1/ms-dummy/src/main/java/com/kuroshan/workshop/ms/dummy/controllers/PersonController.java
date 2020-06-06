package com.kuroshan.workshop.ms.dummy.controllers;

import com.kuroshan.workshop.ms.dummy.models.Person;
import com.kuroshan.workshop.ms.dummy.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping(value = "")
  public ResponseEntity<Person> registerPeople(@RequestBody Person person) {
    return new ResponseEntity<Person>(personService.createPerson(person), HttpStatus.CREATED);
  }

  @GetMapping(value = "")
  public List<Person> listPeople() {
    return personService.findAllPeople();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable long id) {
    Optional<Person> optPerson = personService.findByIdPerson(id);
    return new ResponseEntity<Person>(optPerson.isPresent()?optPerson.get():Person.builder().build(), HttpStatus.OK);
  }

  @PostMapping(value = "/{id}")
  public ResponseEntity<Person> updatePeople(@PathVariable long id, @RequestBody Person person) {
    person.setId(id);
    return new ResponseEntity<Person>(personService.updatePerson(person), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Person> deletePeople(@PathVariable long id) {
    personService.deletePerson(id);
    return new ResponseEntity<Person>(HttpStatus.OK);
  }

}
