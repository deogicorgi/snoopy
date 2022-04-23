package com.github.deogicorgi.snoopy.core.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

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
