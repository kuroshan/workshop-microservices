package com.kuroshan.workshop.ms.hr.employees.services.impl;

import com.kuroshan.workshop.ms.hr.employees.config.AreasClientRest;
import com.kuroshan.workshop.ms.hr.employees.dtos.DepartmentResponse;
import com.kuroshan.workshop.ms.hr.employees.dtos.EmployeeResponse;
import com.kuroshan.workshop.ms.hr.employees.models.Employee;
import com.kuroshan.workshop.ms.hr.employees.repositories.EmployeeRepository;
import com.kuroshan.workshop.ms.hr.employees.services.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private AreasClientRest areasClientRest;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  @HystrixCommand(commandKey = "getEmployeeCommand", fallbackMethod = "temporalGetEmployee")
  public EmployeeResponse findEmployeeById(long id) {
    Employee employee = employeeRepository.findById(id).get();

    DepartmentResponse department = areasClientRest.getDepartment(employee.getDepartmentId());

    EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
    response.setDepartment(department);

    return response;
  }

  private EmployeeResponse temporalGetEmployee(long id) {
    log.error("error de invocación");
    Employee employee = employeeRepository.findById(id).get();
    EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
    response.setDepartment(DepartmentResponse.builder().departmentId(employee.getDepartmentId()).build());
    return response;
  }

}
