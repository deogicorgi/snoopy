package com.github.deogicorgi.snoopy.web.domain.user.service;

import com.github.deogicorgi.snoopy.core.model.User;

/**
 * Process the requested User data and deliver it to the persistence layer.
 * Called from the controller and performs validation and exception handling of the requested data.
 */
public interface UserService {

    /**
     * Converts the requested user data to an entity and forwards it to the persistence layer.
     *
     * @param user User request body
     * @return UserResponse Saved user data.
     */
    User save(User user);

    /**
     * Retrieves single User data via id.
     *
     * @param id userId
     * @return UserResponse Retrieved user data.
     */
    User findById(Long id);

    /**
     * Retrieves single User data via username or email address.
     *
     * @param username username or email address
     * @return UserResponse Retrieved user data.
     */
    User findByUsernameOrEmail(String username);

    /**
     * Converts the requested user data to an entity and forwards it to the persistence layer.
     *
     * @param user User request body
     * @return UserResponse Updated user data.
     */
    User update(User user);

    /**
     * Delete single User data via id.
     *
     * @param id userId
     */
    void deleteById(Long id);
}
