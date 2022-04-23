package com.github.deogicorgi.snoopy.core.web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class JsonApiResponse extends ApiResponse {

    private final Object data;

    public JsonApiResponse(HttpStatus status, Object data) {
        super(status);
        this.data = data;
    }

    public JsonApiResponse() {
        super();
        this.data = null;
    }

}
