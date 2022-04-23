package com.github.deogicorgi.snoopy.core.web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ApiResponse {

    protected final Integer status;
    protected final HttpStatus httpStatus;
    protected final LocalDateTime timestamp;

    protected ApiResponse(HttpStatus httpStatus) {
        this.status = httpStatus.value();
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
    }

    protected ApiResponse() {
        this.httpStatus = HttpStatus.NO_CONTENT;
        this.status = this.httpStatus.value();
        this.timestamp = LocalDateTime.now();
    }
}
