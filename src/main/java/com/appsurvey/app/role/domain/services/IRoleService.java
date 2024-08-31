package com.appsurvey.app.role.domain.services;

import java.util.List;

import com.appsurvey.app.user.domain.entities.User;


public interface IRoleService {
    List<User> findAll();
    User save(User user);
}
