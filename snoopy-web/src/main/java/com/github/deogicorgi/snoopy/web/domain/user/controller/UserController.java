package com.github.deogicorgi.snoopy.web.domain.user.controller;

import com.github.deogicorgi.snoopy.core.web.model.UserRequest;
import com.github.deogicorgi.snoopy.core.web.model.UserResponse;
import com.github.deogicorgi.snoopy.web.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse save(@RequestBody UserRequest user) {
        return userService.save(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse update(@RequestBody UserRequest user) {
        return userService.update(user);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping(params = "username")
    public UserResponse findByUsername(@RequestParam String username) {
        return userService.findByUsernameOrEmail(username);
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

}
