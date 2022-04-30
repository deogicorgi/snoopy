package com.github.deogicorgi.snoopy.web.domain.role.controller;

import com.github.deogicorgi.snoopy.web.domain.role.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/privilege")
@RequiredArgsConstructor
public class PrivilegeController {
    private final PrivilegeService privilegeService;
}
