package com.github.deogicorgi.snoopy.core.orm.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {

    @Column(unique = true, length = 50)
    protected String username;
    @Column(length = 100)
    protected String password;

    @Column(unique = true, length = 100)
    protected String email;

    protected String description;

    protected Boolean isAccountLocked;

    protected Boolean isAccountExpired;

    protected Boolean isCredentialLocked;

    protected Boolean isEnabled;
}
