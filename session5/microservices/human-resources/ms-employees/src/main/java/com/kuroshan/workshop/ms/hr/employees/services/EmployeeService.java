package com.kuroshan.workshop.ms.hr.employees.services;

import com.kuroshan.workshop.ms.hr.employees.dtos.EmployeeResponse;
import com.kuroshan.workshop.ms.hr.employees.models.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAllEmployees();

  EmployeeResponse findEmployeeById(long id);

}
