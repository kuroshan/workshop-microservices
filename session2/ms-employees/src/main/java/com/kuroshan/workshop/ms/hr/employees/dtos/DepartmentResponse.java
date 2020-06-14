package com.kuroshan.workshop.ms.hr.employees.dtos;

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

  private String countryId;

  private String countryName;

  private long regionId;

  private String regionName;

}
