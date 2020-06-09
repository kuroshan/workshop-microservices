package com.kuroshan.workshop.ms.hr.employees.services;

import com.kuroshan.workshop.ms.hr.employees.dtos.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

  public List<EmployeeResponse> findAllEmployees();

}
