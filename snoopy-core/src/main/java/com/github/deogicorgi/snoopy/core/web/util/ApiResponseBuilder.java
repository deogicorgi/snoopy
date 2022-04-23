package com.github.deogicorgi.snoopy.core.web.util;

import com.github.deogicorgi.snoopy.core.web.model.ApiResponse;
import org.springframework.http.ResponseEntity;

public class ApiResponseBuilder {

    public static ResponseEntity<ApiResponse> build(ApiResponse response) {
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
