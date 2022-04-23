package com.github.deogicorgi.snoopy.core.orm.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Role {
    @Column(unique = true, length = 50)
    protected String name;

    @Column(length = 100)
    protected String description;

    protected Boolean isEnabled;
}
