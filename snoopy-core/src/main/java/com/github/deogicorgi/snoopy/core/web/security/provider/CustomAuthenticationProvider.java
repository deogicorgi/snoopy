package com.github.deogicorgi.snoopy.core.web.security.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails member = userDetailsService.loadUserByUsername(username);

        if (ObjectUtils.isEmpty(member)) {
            throw new UsernameNotFoundException("username not found :" + username);
        }

        if (!this.passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("password is not matched");
        }

        if (!member.isEnabled()) {
            throw new DisabledException("this account is disabled.");
        }

        if (!member.isAccountNonExpired()) {
            throw new AccountExpiredException("this account is expired.");
        }

        if (!member.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("this credential has expired.");
        }

        if (!member.isAccountNonLocked()) {
            throw new LockedException("this account is locked.");
        }

        log.info("name : {}, password : {}", username, password);
        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
