package com.appsurvey.app.user.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.appsurvey.app.user.domain.entities.User;
import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username); 

}
