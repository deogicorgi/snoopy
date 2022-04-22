package com.github.deogicorgi.snoopy.core.web.service;

import com.github.deogicorgi.snoopy.core.orm.entity.User;

public interface UserService {

    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    User save(User user);
}
