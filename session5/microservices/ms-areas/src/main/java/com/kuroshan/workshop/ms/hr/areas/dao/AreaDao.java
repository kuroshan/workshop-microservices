package com.kuroshan.workshop.ms.hr.areas.dao;

import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;

public interface AreaDao {

  Tuple findDepartmentByIdCustom(long id);

}
