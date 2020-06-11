package com.kuroshan.workshop.ms.hr.employees.services.impl;

import com.kuroshan.workshop.ms.hr.employees.models.Employee;
import com.kuroshan.workshop.ms.hr.employees.repositories.EmployeeRepository;
import com.kuroshan.workshop.ms.hr.employees.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

}
