package com.github.deogicorgi.snoopy.core.security.model;

import com.github.deogicorgi.snoopy.core.model.Privilege;
import com.github.deogicorgi.snoopy.core.model.Role;
import com.github.deogicorgi.snoopy.core.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityUserDetails implements UserDetails {

    private final User user;

    private final Set<RoleAndPrivilegeAuthority> authorities = new HashSet<>();

    public SecurityUserDetails(User user) {
        this.user = user;
        Role role = this.user.getRole();
        Set<Privilege> privileges = this.user.getRole().getPrivileges();
        RoleAndPrivilegeAuthority roleAndPrivilegeAuthority = new RoleAndPrivilegeAuthority(role);
        authorities.add(roleAndPrivilegeAuthority);
        authorities.addAll(privileges.stream().map(RoleAndPrivilegeAuthority::new).collect(Collectors.toSet()));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.user.getIsAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.user.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.user.getIsCredentialLocked();
    }

    @Override
    public boolean isEnabled() {
        return this.user.getIsEnabled();
    }
}
