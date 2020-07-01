package com.kuroshan.workshop.ms.hr.employees.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "EMPLOYEES", schema = "HR", catalog = "")
public class Employee {

  @Id
  @Column(name = "EMPLOYEE_ID")
  private long employeeId;

  @Basic
  @Column(name = "FIRST_NAME")
  private String firstName;

  @Basic
  @Column(name = "LAST_NAME")
  private String lastName;

  @Basic
  @Column(name = "EMAIL")
  private String email;

  @Basic
  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Basic
  @Column(name = "HIRE_DATE")
  private Time hireDate;

  @Basic
  @Column(name = "SALARY")
  private Long salary;

  @Basic
  @Column(name = "COMMISSION_PCT")
  private Long commissionPct;

  @Basic
  @Column(name = "DEPARTMENT_ID")
  private Long departmentId;

}
