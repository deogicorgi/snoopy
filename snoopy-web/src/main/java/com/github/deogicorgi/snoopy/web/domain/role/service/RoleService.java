package com.github.deogicorgi.snoopy.web.domain.role.service;

import com.github.deogicorgi.snoopy.core.web.model.RoleRequest;
import com.github.deogicorgi.snoopy.core.web.model.RoleResponse;

/**
 * Process the requested Role data and deliver it to the persistence layer.
 * Called from the controller and performs validation and exception handling of the requested data.
 */
public interface RoleService {

    /**
     * Converts the requested user data to an entity and forwards it to the persistence layer.
     *
     * @param role Role request body
     * @return RoleResponse Saved role data.
     */
    RoleResponse save(RoleRequest role);

    /**
     * Converts the requested user data to an entity and forwards it to the persistence layer.
     *
     * @param role Role request body
     * @return RoleResponse Updated role data.
     */
    RoleResponse update(RoleRequest role);

    /**
     * Retrieves single Role data via id.
     *
     * @param id roleId
     * @return RoleResponse Retrieved role data.
     */
    RoleResponse findById(Long id);

    /**
     * Delete single User data via id.
     *
     * @param id userId
     */
    void deleteById(Long id);
}
