package com.github.deogicorgi.snoopy.web.domain.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final Environment environment;

    @GetMapping("/")
    public String index() {
        return "redirect:/app/login";
    }

    @GetMapping("/app/login")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("app/login");
        mav.addObject("title", environment.getProperty("application.title"));
        return mav;
    }
}
