package com.github.deogicorgi.snoopy.core.orm.service;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;

/**
 * Persistence layer that implements logic to access the database with parameter data.
 * Use transactions.
 */
public interface UserPersistService {

    /**
     * Retrieves single User entity via id.
     *
     * @param id user id
     * @return UserEntity
     */
    UserEntity findById(Long id);

    /**
     * Retrieves single User entity via username.
     *
     * @param username username
     * @return UserEntity
     */
    UserEntity findByUsername(String username);

    /**
     * Retrieves single User entity via email address.
     *
     * @param email email address
     * @return UserEntity
     */
    UserEntity findByEmail(String email);

    /**
     * Retrieves single User entity via username or email address.
     *
     * @param username username or email address
     * @return UserEntity
     */
    UserEntity findByUsernameOrEmail(String username);

    /**
     * Retrieves single User entity via username and password.
     *
     * @param username username
     * @param password encoded password
     * @return UserEntity
     */
    UserEntity findByUsernameAndPassword(String username, String password);

    /**
     * Save single User entity via copied user entity.
     *
     * @param userEntity copied user entity
     * @return UserEntity saved user entity
     */
    UserEntity save(UserEntity userEntity);

    /**
     * Update single User entity via copied user entity.
     *
     * @param userEntity copied user entity
     * @return UserEntity updated user entity
     */
    UserEntity update(UserEntity userEntity);

    /**
     * Delete single User entity via id.
     *
     * @param id userId
     */
    void delete(Long id);
}
