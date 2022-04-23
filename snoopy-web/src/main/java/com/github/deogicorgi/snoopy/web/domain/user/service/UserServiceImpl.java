package com.github.deogicorgi.snoopy.web.domain.user.service;

import com.github.deogicorgi.snoopy.core.orm.service.UserPersistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPersistService userPersistService;
}
