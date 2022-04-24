package com.github.deogicorgi.snoopy.core.orm.service;

import com.github.deogicorgi.snoopy.core.orm.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RolePersistServiceImpl implements RolePersistService {

    private final RoleRepository roleRepository;
}
