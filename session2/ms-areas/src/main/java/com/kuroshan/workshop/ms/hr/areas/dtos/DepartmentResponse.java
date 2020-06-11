package com.kuroshan.workshop.ms.hr.areas.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class DepartmentResponse {

  private long departmentId;

  private String departmentName;

  private long locationId;

  private String streetAddress;

}
