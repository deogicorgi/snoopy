package com.github.deogicorgi.snoopy.core.security.model;

import org.springframework.security.core.GrantedAuthority;

public class RoleAndPrivilegeAuthority implements GrantedAuthority {

    private final Authority authority;

    public RoleAndPrivilegeAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
