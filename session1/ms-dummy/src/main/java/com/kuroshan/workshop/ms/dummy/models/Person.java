package com.kuroshan.workshop.ms.dummy.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TBL_PERSON")
public class Person {

  @Id
  @Column(name = "PERSON_ID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name = "FIRST_NAME")
  @NotNull(message = "First Name cannot be null")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EGA")
  @Min(value = 18, message = "Age should not be less than 18")
  @Max(value = 65, message = "Age should not be greater than 65")
  private int age;

  @Column(name = "TYPE_DOCUMENT")
  private String typeDocument;

  @Column(name = "IDENTITY_DOCUMENT")
  private String idDocument;

}
