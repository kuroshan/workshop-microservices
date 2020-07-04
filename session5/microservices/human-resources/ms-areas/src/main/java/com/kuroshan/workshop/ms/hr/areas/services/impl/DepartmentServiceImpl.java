package com.kuroshan.workshop.ms.hr.areas.services.impl;

import com.kuroshan.workshop.ms.hr.areas.dao.AreaDao;
import com.kuroshan.workshop.ms.hr.areas.models.Department;
import com.kuroshan.workshop.ms.hr.areas.repositories.DepartmentRepository;
import com.kuroshan.workshop.ms.hr.areas.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private AreaDao areaDao;

  @Override
  @Transactional(readOnly = true)
  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public Department findById(long id) {
    return departmentRepository.findById(id).orElse(null);
  }

  @Override
  public Tuple findByIdCustom(long id) {
    return areaDao.findDepartmentByIdCustom(id);
  }

  @Override
  public List<Department> findByDepartmentName(String name) {
    return departmentRepository.findByDepartmentName(name);
  }

  @Override
  public List<Department> searchByDepartmentName(String name) {
    return departmentRepository.searchByDepartmentName(name);
  }

}
