package com.github.deogicorgi.snoopy.core.web.model;

import com.github.deogicorgi.snoopy.core.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest extends User {
    private Long id;
}
