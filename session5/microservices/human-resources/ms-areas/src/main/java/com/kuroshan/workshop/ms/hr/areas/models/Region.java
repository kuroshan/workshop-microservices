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
@Table(name = "REGIONS", schema = "HR", catalog = "")
public class Region {

  @Id
  @Column(name = "REGION_ID")
  private long regionId;

  @Basic
  @Column(name = "REGION_NAME")
  private String regionName;

}
