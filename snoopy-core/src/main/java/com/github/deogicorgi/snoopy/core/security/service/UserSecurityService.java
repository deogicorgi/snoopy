package com.github.deogicorgi.snoopy.core.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserSecurityService {
    UserDetails getUserByPrincipal(String username);
}
