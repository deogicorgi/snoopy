package com.github.deogicorgi.snoopy.web.domain.role.service;

import com.github.deogicorgi.snoopy.core.orm.service.RolePersistService;
import com.github.deogicorgi.snoopy.core.web.model.RoleRequest;
import com.github.deogicorgi.snoopy.core.web.model.RoleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RolePersistService rolePersistService;

    @Override
    public RoleResponse save(RoleRequest role) {

//        validate(user);
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        UserEntity savedEntity = userPersistService.save(new UserEntity(user));
//        UserResponse userResponse = new UserResponse();
//        BeanUtils.copyProperties(savedEntity, userResponse);
//        return userResponse;
        return null;
    }

    @Override
    public RoleResponse update(RoleRequest role) {
        return null;
    }

    @Override
    public RoleResponse findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    /**********************************************************
     ************************ validate ************************
     **********************************************************/

    /**
     * Validate the User body data.
     *
     * @param role requested role body
     */
    private void validate(RoleRequest role) {

        if (ObjectUtils.isEmpty(role.getName())) {

        }
    }
}
