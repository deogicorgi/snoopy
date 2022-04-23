package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.User;
import com.github.deogicorgi.snoopy.core.web.model.UserRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity extends User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialLocked;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public UserEntity(UserRequest request) {
        this.id = request.getId();
        this.username = request.getUsername();
        this.email = request.getEmail();
        this.description = request.getDescription();
        this.password = request.getPassword();
        this.isAccountExpired = ObjectUtils.isEmpty(request.getIsAccountExpired()) || request.getIsAccountExpired();
        this.isAccountLocked = ObjectUtils.isEmpty(request.getIsAccountLocked()) || request.getIsAccountLocked();
        this.isCredentialLocked = ObjectUtils.isEmpty(request.getIsCredentialLocked()) || request.getIsCredentialLocked();
        this.isEnabled = ObjectUtils.isEmpty(request.getIsEnabled()) || request.getIsEnabled();
    }

}
