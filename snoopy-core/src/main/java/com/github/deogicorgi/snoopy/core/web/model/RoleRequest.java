package com.github.deogicorgi.snoopy.core.web.model;

import com.github.deogicorgi.snoopy.core.model.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest extends AbstractRole {
    private Long id;
}