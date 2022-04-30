package com.github.deogicorgi.snoopy.web.domain.user.service;

import com.github.deogicorgi.snoopy.core.model.Role;
import com.github.deogicorgi.snoopy.core.model.User;
import com.github.deogicorgi.snoopy.core.model.UserStatus;
import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import com.github.deogicorgi.snoopy.core.orm.service.UserPersistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
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
    public User save(User user) {

        validate(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserStatus(new UserStatus());
        user.setRole(new Role());
        UserEntity savedEntity = userPersistService.save(new UserEntity.UserEntityBuilder(user).build());
        return new User.UserBuilder(savedEntity).build();
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = userPersistService.findById(id);

        if (ObjectUtils.isEmpty(entity)) {
            // TODO NotfoundException
        }
        return new User.UserBuilder(entity).build();
    }

    @Override
    public User findByUsernameOrEmail(String username) {
        UserEntity entity = userPersistService.findByUsernameOrEmail(username);

        if (ObjectUtils.isEmpty(entity)) {
            // TODO NotfoundException
        }

        return new User.UserBuilder(entity).build();
    }

    @Override
    public User update(User user) {

        validate(user);

        UserEntity entity = userPersistService.update(new UserEntity.UserEntityBuilder(user).build());

        if (ObjectUtils.isEmpty(entity)) {
            // TODO NotfoundException
        }

        return new User.UserBuilder(entity).build();
    }

    @Override
    public void deleteById(Long id) {
        userPersistService.delete(id);
    }

    /**********************************************************
     ************************ validate ************************
     **********************************************************/

    /**
     * Validate the User body data.
     *
     * @param user requested user body
     */
    private void validate(User user) {

        if (ObjectUtils.isEmpty(user.getUsername())) {

        }

        if (ObjectUtils.isEmpty(user.getPassword())) {

        }

        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new RuntimeException("email!!");
        }
    }
}
