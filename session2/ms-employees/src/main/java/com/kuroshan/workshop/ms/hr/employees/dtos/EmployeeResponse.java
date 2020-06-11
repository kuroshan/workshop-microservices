package com.kuroshan.workshop.ms.hr.employees.dtos;

import lombok.*;

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

  private Long departmentId;

}
