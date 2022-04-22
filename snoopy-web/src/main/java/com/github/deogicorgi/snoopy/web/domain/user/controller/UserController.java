package com.github.deogicorgi.snoopy.web.domain.user.controller;

import com.github.deogicorgi.snoopy.core.orm.entity.User;
import com.github.deogicorgi.snoopy.core.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(User member) {


        return member;
    }

    @GetMapping("/{memberId}")
    public User read(@PathVariable Long memberId) {
        return null;
    }
}
