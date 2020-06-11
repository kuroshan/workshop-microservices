package com.kuroshan.workshop.ms.hr.areas.repositories;

import com.kuroshan.workshop.ms.hr.areas.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  @Query("SELECT d FROM Department d  WHERE UPPER(d.departmentName) like UPPER(CONCAT('%',:name,'%'))")
  List<Department> findByDepartmentName(@Param("name") String name);

  @Query("SELECT d.departmentId as departmentId, d.departmentName as departmentName, " +
                "l.locationId as locationId, l.streetAddress as streetAddress " +
           "FROM Department d, Location l " +
          "WHERE d.location.locationId = l.locationId " +
            "AND d.departmentId = :id")
  Tuple findDepartment(@Param("id") long id);

}
