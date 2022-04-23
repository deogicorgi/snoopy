package com.github.deogicorgi.snoopy.web.domain.user.service;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import com.github.deogicorgi.snoopy.core.orm.service.UserPersistService;
import com.github.deogicorgi.snoopy.core.web.model.UserRequest;
import com.github.deogicorgi.snoopy.core.web.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPersistService userPersistService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse save(UserRequest user) {

        validate(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedEntity = userPersistService.save(new UserEntity(user));
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(savedEntity, userResponse);
        return userResponse;
    }

    @Override
    public UserResponse findById(Long id) {
        UserEntity entity = userPersistService.findById(id);

        if (ObjectUtils.isEmpty(entity)) {
            // TODO NotfoundException
        }

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }

    @Override
    public UserResponse findByUsernameOrEmail(String username) {
        UserEntity entity = userPersistService.findByUsernameOrEmail(username);

        if (ObjectUtils.isEmpty(entity)) {
            // TODO NotfoundException
        }

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }

    /**********************************************************
     ************************ validate ************************
     **********************************************************/

    private void validate(UserRequest user) {

        if (ObjectUtils.isEmpty(user.getUsername())) {

        }

        if (ObjectUtils.isEmpty(user.getPassword())) {

        }

        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new RuntimeException("email!!");
        }
    }
}
