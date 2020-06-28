package com.kuroshan.workshop.ms.hr.security.server.config;

import com.kuroshan.workshop.ms.hr.security.server.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-hr-users")
public interface UsersClientRest {

  @GetMapping("/users/search/username")
  User findByUsername(@RequestParam String name);

}
