package com.github.deogicorgi.snoopy.core.security.service;

import com.github.deogicorgi.snoopy.core.model.User;
import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import com.github.deogicorgi.snoopy.core.orm.service.UserPersistService;
import com.github.deogicorgi.snoopy.core.security.model.SecurityUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserSecurityServiceImpl implements UserSecurityService {

    private final UserPersistService userPersistService;

    @Override
    public UserDetails getUserByPrincipal(String username) {
        UserEntity userEntity = userPersistService.findByUsernameOrEmail(username);

        if (ObjectUtils.isEmpty(userEntity)) {
            return null;
        }

        return new SecurityUserDetails(new User.UserBuilder(userEntity).build());
    }
}
