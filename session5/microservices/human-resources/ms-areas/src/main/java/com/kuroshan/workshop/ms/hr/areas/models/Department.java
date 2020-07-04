package com.kuroshan.workshop.ms.hr.areas.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "DEPARTMENTS", schema = "HR", catalog = "")
public class Department {

  @Id
  @Column(name = "DEPARTMENT_ID")
  private long departmentId;

  @Basic
  @Column(name = "DEPARTMENT_NAME")
  private String departmentName;

  @ManyToOne
  @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
  private Location location;

}
