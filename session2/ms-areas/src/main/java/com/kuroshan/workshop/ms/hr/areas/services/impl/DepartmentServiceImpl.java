package com.kuroshan.workshop.ms.hr.areas.services.impl;

import com.kuroshan.workshop.ms.hr.areas.models.Department;
import com.kuroshan.workshop.ms.hr.areas.repositories.DepartmentRepository;
import com.kuroshan.workshop.ms.hr.areas.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departamentRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Department> findAll() {
    return departamentRepository.findAll();
  }

  @Override
  public Department findById(long id) {
    return departamentRepository.findById(id).orElse(null);
  }

  @Override
  public List<Department> findByDepartmentName(String name) {
    return departamentRepository.findByDepartmentName(name);
  }

  @Override
  public Tuple findDepartment(long id) {
    return departamentRepository.findDepartment(id);
  }

}
