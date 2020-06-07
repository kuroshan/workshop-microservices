package com.kuroshan.workshop.ms.dummy.services.impl;

import com.kuroshan.workshop.ms.dummy.models.Person;
import com.kuroshan.workshop.ms.dummy.repositories.PersonRepository;
import com.kuroshan.workshop.ms.dummy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
  public Person findByIdPerson(Long id) {
    Optional<Person> optEntity = personRepository.findById(id);
    if (optEntity.isPresent()) {
      return optEntity.get();
    } else {
      throw new EntityNotFoundException(String.format("person with id %d not found", id));
    }
  }

  @Override
  public Person updatePerson(Person entity) {
    Optional<Person> optEntity = personRepository.findById(entity.getId());
    if (optEntity.isPresent()) {
      optEntity.get().setFirstName(entity.getFirstName());
      optEntity.get().setLastName(entity.getLastName());
      entity = personRepository.save(optEntity.get());
    } else {
      throw new EntityNotFoundException(String.format("person with id %d not found", entity.getId()));
    }
    return entity;
  }

  @Override
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }
}
