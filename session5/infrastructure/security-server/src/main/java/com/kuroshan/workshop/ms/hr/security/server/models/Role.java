package com.kuroshan.workshop.ms.hr.security.server.models;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Role implements Serializable {

  private long id;

  private String name;

}
