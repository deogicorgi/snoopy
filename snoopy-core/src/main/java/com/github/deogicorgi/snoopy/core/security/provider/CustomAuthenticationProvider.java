package com.github.deogicorgi.snoopy.core.security.provider;

import com.github.deogicorgi.snoopy.core.security.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserSecurityService userSecurityService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = userSecurityService.getUserByPrincipal(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("username or email not found :" + username);
        }

        if (!this.passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("password is not matched");
        }

        if (!user.isEnabled()) {
            throw new DisabledException("this account is disabled.");
        }

        if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("this account is expired.");
        }

        if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("this credential has expired.");
        }

        if (!user.isAccountNonLocked()) {
            throw new LockedException("this account is locked.");
        }

        log.info("Authentication - username : {}, enabled : {}, account-lock : {}, account-expired : {}, credential-expired : {}",
                user.getUsername(), user.isEnabled(), !user.isAccountNonLocked(), !user.isAccountNonExpired(), !user.isCredentialsNonExpired());
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
