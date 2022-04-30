package com.github.deogicorgi.snoopy.core.orm.service;

import com.github.deogicorgi.snoopy.core.orm.repository.PrivilegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrivilegePersistServiceImpl implements PrivilegePersistService {
    private final PrivilegeRepository privilegeRepository;
}
