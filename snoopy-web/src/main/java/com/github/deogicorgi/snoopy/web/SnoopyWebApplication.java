package com.github.deogicorgi.snoopy.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
        scanBasePackages = {
                "com.github.deogicorgi.snoopy.core",
                "com.github.deogicorgi.snoopy.web"
        }
)
public class SnoopyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnoopyWebApplication.class, args);
    }

}
