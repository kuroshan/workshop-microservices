package com.kuroshan.workshop.ms.hr.employees.dtos;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class EmployeeResponse {

  private long employeeId;

  private String firstName;

  private String lastName;

  private String email;

  private String phoneNumber;

  private Time hireDate;

  private Long departmentId;

}
