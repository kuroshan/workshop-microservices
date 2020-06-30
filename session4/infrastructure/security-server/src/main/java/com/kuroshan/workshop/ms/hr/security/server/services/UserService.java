package com.kuroshan.workshop.ms.hr.security.server.services;

import com.kuroshan.workshop.ms.hr.security.server.models.User;

public interface UserService {

  User findByUsername(String username);

}
