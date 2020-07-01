package com.kuroshan.workshop.ms.hr.users.repositories;

import com.kuroshan.workshop.ms.hr.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

  @RestResource(path = "username")
  User findByUsername(@Param("name") String username);

  @Query("select u from User u where u.username = ?1")
  User obtenerPorNombreUsuario(String nombreUsuario);

}
