package com.kuroshan.workshop.ms.hr.security.server.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class User implements Serializable {

  private long id;

  private String username;

  private String password;

  private String email;

  private Boolean enabled;

  private List<Role> roles;

}
