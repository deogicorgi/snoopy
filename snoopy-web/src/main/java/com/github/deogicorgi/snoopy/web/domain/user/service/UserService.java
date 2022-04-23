package com.github.deogicorgi.snoopy.web.domain.user.service;

import com.github.deogicorgi.snoopy.core.web.model.UserRequest;
import com.github.deogicorgi.snoopy.core.web.model.UserResponse;

public interface UserService {
    UserResponse save(UserRequest user);

    UserResponse findById(Long id);

    UserResponse findByUsernameOrEmail(String username);
}
