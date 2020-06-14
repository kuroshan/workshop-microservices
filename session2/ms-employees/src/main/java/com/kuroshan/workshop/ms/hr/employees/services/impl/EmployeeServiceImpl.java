package com.kuroshan.workshop.ms.hr.employees.services.impl;

import com.kuroshan.workshop.ms.hr.employees.dtos.DepartmentResponse;
import com.kuroshan.workshop.ms.hr.employees.dtos.EmployeeResponse;
import com.kuroshan.workshop.ms.hr.employees.models.Employee;
import com.kuroshan.workshop.ms.hr.employees.repositories.EmployeeRepository;
import com.kuroshan.workshop.ms.hr.employees.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.support.ms-human-resources-areas.url:http://localhost:8082/ms-hr-areas/v1}")
  private String apiSupportMsHumanResourcesAreas;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public EmployeeResponse findEmployeeById(long id) {
    Employee employee = employeeRepository.findById(id).get();

    Map vars = new HashMap();
    vars.put("id", employee.getDepartmentId());
    DepartmentResponse department = restTemplate.getForObject(apiSupportMsHumanResourcesAreas + "/departments/custom/{id}", DepartmentResponse.class, vars);

    EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
    response.setDepartment(department);

    return response;
  }

}
