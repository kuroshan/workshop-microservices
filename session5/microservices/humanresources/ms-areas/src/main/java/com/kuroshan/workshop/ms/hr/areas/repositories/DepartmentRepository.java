package com.kuroshan.workshop.ms.hr.areas.repositories;

import com.kuroshan.workshop.ms.hr.areas.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  List<Department> findByDepartmentName(String name);

  @Query("SELECT d FROM Department d  WHERE UPPER(d.departmentName) like UPPER(CONCAT('%',:name,'%'))")
  List<Department> searchByDepartmentName(@Param("name") String name);

}
