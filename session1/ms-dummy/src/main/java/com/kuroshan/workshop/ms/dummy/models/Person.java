package com.kuroshan.workshop.ms.dummy.models;

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
@Table(name = "TBL_PERSON")
public class Person {

  @Id
  @Column(name = "PERSON_ID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EGA")
  private int age;

  @Column(name = "TYPE_DOCUMENT")
  private String typeDocument;

  @Column(name = "IDENTITY_DOCUMENT")
  private String idDocument;

}
