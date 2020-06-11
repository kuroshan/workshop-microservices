package com.kuroshan.workshop.ms.hr.areas.services;

import com.kuroshan.workshop.ms.hr.areas.models.Department;

import javax.persistence.Tuple;
import java.util.List;

public interface DepartmentService {

  List<Department> findAll();

  Department findById(long id);

  List<Department> findByDepartmentName(String name);

  Tuple findDepartment(long id);

}
