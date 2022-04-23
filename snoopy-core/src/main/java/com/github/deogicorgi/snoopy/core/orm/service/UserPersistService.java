package com.github.deogicorgi.snoopy.core.orm.service;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;

public interface UserPersistService {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity save(UserEntity userEntity);
}
