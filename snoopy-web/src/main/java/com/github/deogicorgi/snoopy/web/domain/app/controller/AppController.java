package com.github.deogicorgi.snoopy.web.domain.app.controller;

import com.github.deogicorgi.snoopy.web.domain.app.values.AppPath;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final Environment environment;

    @GetMapping(value = {"/login", "/", "/index"})
    public String toLogin(Model mav) {
        mav.addAttribute("title", environment.getProperty("app.title"));
        return this.getPath(AppPath.INDEX);
    }

    @GetMapping("/main")
    public String toMain() {
        return this.getPath(AppPath.MAIN);
    }

    @GetMapping("/user/add")
    public String toAddUser() {
        return this.getPath(AppPath.ADD_USER);
    }

    private String getPath(AppPath path) {
        String PATH_PREFIX = "app/";
        return PATH_PREFIX + path.getPath();
    }
}
