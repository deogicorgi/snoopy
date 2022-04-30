package com.github.deogicorgi.snoopy.web.domain.role.controller;

import com.github.deogicorgi.snoopy.core.web.model.ApiResponse;
import com.github.deogicorgi.snoopy.core.web.model.JsonApiResponse;
import com.github.deogicorgi.snoopy.core.web.model.RoleRequest;
import com.github.deogicorgi.snoopy.core.web.util.ApiResponseBuilder;
import com.github.deogicorgi.snoopy.web.domain.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> save(@RequestBody RoleRequest role) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.CREATED, roleService.save(role)));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> update(@RequestBody RoleRequest user) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.OK, roleService.update(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return ApiResponseBuilder.build(new JsonApiResponse(HttpStatus.OK, roleService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
        return ApiResponseBuilder.build(new JsonApiResponse());
    }
}
