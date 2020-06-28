package com.kuroshan.workshop.ms.hr.security.server.services.impl;

import com.kuroshan.workshop.ms.hr.security.server.config.UsersClientRest;
import com.kuroshan.workshop.ms.hr.security.server.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {

  @Autowired
  private UsersClientRest usersClientRest;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = usersClientRest.findByUsername(username);

    if (user == null) {
      log.error("No exist user: " + username);
      throw new UsernameNotFoundException("No exist user: " + username);
    }

    List<GrantedAuthority> authorities = user.getRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .peek(authority -> log.info("Role: " + authority.getAuthority()))
        .collect(Collectors.toList());

    return new org.springframework.security.core.userdetails
        .User(user.getUsername(),
              user.getPassword(),
              user.getEnabled(),
            true,
          true,
            true,
              authorities);
  }

}
