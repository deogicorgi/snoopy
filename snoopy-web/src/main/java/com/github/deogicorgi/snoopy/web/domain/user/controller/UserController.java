package com.github.deogicorgi.snoopy.web.domain.user.controller;

import com.github.deogicorgi.snoopy.core.model.User;
import com.github.deogicorgi.snoopy.core.web.model.ApiResponse;
import com.github.deogicorgi.snoopy.core.web.model.JsonApiResponse;
import com.github.deogicorgi.snoopy.core.web.util.ApiResponseBuilder;
import com.github.deogicorgi.snoopy.web.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> save(@RequestBody User user) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.CREATED, userService.save(user)));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> update(@RequestBody User user) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.OK, userService.update(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.OK, userService.findById(id)));
    }

    @GetMapping(params = "username")
    public ResponseEntity<ApiResponse> findByUsername(@RequestParam String username) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.OK, userService.findByUsernameOrEmail(username)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ApiResponseBuilder.build(new JsonApiResponse());
    }

}
