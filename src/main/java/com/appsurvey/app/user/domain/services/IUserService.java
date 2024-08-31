package com.appsurvey.app.user.domain.services;


import java.util.List;

import com.appsurvey.app.user.domain.entities.User;

public interface IUserService {
    List<User> findAll();
    User save(User user);
}
