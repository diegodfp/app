package com.appsurvey.app.role.infraestructure.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.appsurvey.app.role.domain.entities.Role;

public interface RoleRepository  extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
