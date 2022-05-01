package com.github.deogicorgi.snoopy.web.domain.app.values;

import lombok.Getter;

@Getter
public enum AppPath {
    INDEX("index"),
    MAIN("main"),
    ADD_USER("add_user");

    private final String path;

    AppPath(String path) {
        this.path = path;
    }
}
