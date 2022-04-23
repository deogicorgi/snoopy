package com.github.deogicorgi.snoopy.web.domain.user.controller;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import com.github.deogicorgi.snoopy.web.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity create(UserEntity member) {

        return member;
    }

    @GetMapping("/{memberId}")
    public UserEntity read(@PathVariable Long memberId) {
        return null;
    }
}
