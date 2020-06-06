package com.kuroshan.workshop.ms.dummy.services;

import com.kuroshan.workshop.ms.dummy.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

  Person createPerson(Person entity);
  List<Person> findAllPeople();
  Optional<Person> findByIdPerson(Long id);
  Person updatePerson(Person entity);
  void deletePerson(Long id);

}
