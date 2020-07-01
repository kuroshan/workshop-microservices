package com.kuroshan.workshop.ms.hr.users.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

  @Id
  @Column(name = "ROLE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, length = 30)
  private String name;

  /*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
  private List<User> users;*/

}
