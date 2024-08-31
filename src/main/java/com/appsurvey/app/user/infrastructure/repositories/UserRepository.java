package com.appsurvey.app.user.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.appsurvey.app.user.domain.entities.User;

public interface UserRepository  extends CrudRepository<User, Long> {

}
