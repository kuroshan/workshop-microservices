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
@Table(name = "COUNTRIES", schema = "HR", catalog = "")
public class Country {

  @Id
  @Column(name = "COUNTRY_ID")
  private String countryId;

  @Basic
  @Column(name = "COUNTRY_NAME")
  private String countryName;

  @ManyToOne
  @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
  private Region region;

}
