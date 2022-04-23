package com.github.deogicorgi.snoopy.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Privilege {

    @Column(unique = true, length = 50)
    protected String name;

    @Column(length = 100)
    protected String description;
}
