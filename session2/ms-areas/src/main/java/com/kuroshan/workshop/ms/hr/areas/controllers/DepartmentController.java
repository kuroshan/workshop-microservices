package com.kuroshan.workshop.ms.hr.areas.controllers;

import com.kuroshan.workshop.ms.hr.areas.dtos.DepartmentResponse;
import com.kuroshan.workshop.ms.hr.areas.models.Department;
import com.kuroshan.workshop.ms.hr.areas.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
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
  @ResponseStatus(HttpStatus.OK)
  public List<DepartmentResponse> listDepartaments(@RequestParam(value = "name", required = false) String name) {
    List<Department> list;
    if (name != null) {
      list = departamentService.searchByDepartmentName(name);
    } else {
      list = departamentService.findAll();
    }
    return modelMapper.map(list, new TypeToken<List<DepartmentResponse>>() {}.getType());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity getDepartment(@PathVariable long id) {
    Department d = departamentService.findById(id);
    return d != null
        ? new ResponseEntity(d, HttpStatus.OK)
        : new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "/custom/{id}")
  public ResponseEntity getDepartmentCustom(@PathVariable long id) {
    Tuple t = departamentService.findByIdCustom(id);
    return t != null
        ? new ResponseEntity(builderResponse(t), HttpStatus.OK)
        : new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  private DepartmentResponse builderResponse(Tuple t) {
    return DepartmentResponse
        .builder()
        .departmentId(t.get("departmentId", Long.class))
        .departmentName(t.get("departmentName", String.class))
        .locationId(t.get("locationId", Long.class))
        .streetAddress(t.get("streetAddress", String.class))
        .countryId(t.get("countryId", String.class))
        .countryName(t.get("countryName", String.class))
        .regionId(t.get("regionId", Long.class))
        .regionName(t.get("regionName", String.class))
        .build();
  }

}
