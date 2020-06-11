package com.kuroshan.workshop.ms.hr.areas.controllers;

import com.kuroshan.workshop.ms.hr.areas.dtos.DepartmentResponse;
import com.kuroshan.workshop.ms.hr.areas.models.Department;
import com.kuroshan.workshop.ms.hr.areas.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departamentService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = "")
  public List<Department> listDepartaments(@RequestParam(value = "name", required = false) String name) {
    List<Department> list = new ArrayList<Department>();
    if (name != null) {
      list = departamentService.findByDepartmentName(name);
    } else {
      list = departamentService.findAll();
    }
    return list;
  }

  @GetMapping(value = "/{id}")
  public Department getDepartament(@PathVariable long id) {
    return departamentService.findById(id);
  }

  @GetMapping(value = "/tuple/{id}")
  public DepartmentResponse getDepartamentTuple(@PathVariable long id) {
    Tuple t = departamentService.findDepartment(id);
    return DepartmentResponse.builder().departmentName(t.get("departmentName").toString()).build();
  }

}
