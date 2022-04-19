package com.github.deogicorgi.snoopy.core.web.security.service;

import com.github.deogicorgi.snoopy.core.domain.model.Member;
import com.github.deogicorgi.snoopy.core.web.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SnoopyMemberService implements UserDetailsService, MemberService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user detail service!");
        Member member = new Member();

        return member;
    }

    @Override
    public void create() {
    }
}
