package com.kuroshan.workshop.ms.hr.employees.controllers;

import com.kuroshan.workshop.ms.hr.employees.dtos.EmployeeResponse;
import com.kuroshan.workshop.ms.hr.employees.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = "")
  @ResponseStatus(HttpStatus.OK)
  public List<EmployeeResponse> listEmployees() {
    return modelMapper.map(employeeService.findAllEmployees(), new TypeToken<List<EmployeeResponse>>() {}.getType());
  }

}
