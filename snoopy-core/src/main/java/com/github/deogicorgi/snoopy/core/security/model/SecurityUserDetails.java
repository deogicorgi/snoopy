package com.github.deogicorgi.snoopy.core.security.model;

import com.github.deogicorgi.snoopy.core.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUserDetails implements UserDetails {

    private final User user;

    public SecurityUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return !this.user.getUserStatus().getIsAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.user.getUserStatus().getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.user.getUserStatus().getIsCredentialLocked();
    }

    @Override
    public boolean isEnabled() {
        return this.user.getUserStatus().getIsEnabled();
    }
}
