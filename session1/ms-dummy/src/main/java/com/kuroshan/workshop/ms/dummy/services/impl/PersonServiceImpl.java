package com.kuroshan.workshop.ms.dummy.services.impl;

import com.kuroshan.workshop.ms.dummy.models.Person;
import com.kuroshan.workshop.ms.dummy.repositories.PersonRepository;
import com.kuroshan.workshop.ms.dummy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public Person createPerson(Person entity) {
    return personRepository.save(entity);
  }

  @Override
  public List<Person> findAllPeople() {
    return personRepository.findAll();
  }

  @Override
  public Optional<Person> findByIdPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Person updatePerson(Person entity) {
    Optional<Person> optEntity = personRepository.findById(entity.getId());
    if (optEntity.isPresent()) {
      optEntity.get().setFirstName(entity.getFirstName());
      optEntity.get().setLastName(entity.getLastName());
      entity = personRepository.save(optEntity.get());
    }
    return entity;
  }

  @Override
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }
}
