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
public abstract class AbstractPrivilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    protected String name;

    @Column(length = 100)
    protected String description;
}
