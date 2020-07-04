package com.kuroshan.workshop.ms.hr.users.config;

import com.kuroshan.workshop.ms.hr.users.models.Role;
import com.kuroshan.workshop.ms.hr.users.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(User.class, Role.class);
  }
}
