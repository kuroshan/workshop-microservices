package com.kuroshan.workshop.ms.hr.employees.config;

import com.kuroshan.workshop.ms.hr.employees.dtos.DepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-hr-areas", path = "/v1")
public interface AreasClientRest {

  @GetMapping(value = "/departments/custom/{id}")
  public DepartmentResponse getDepartment(@PathVariable long id);

}
