package com.github.deogicorgi.snoopy.core.orm.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    private Boolean isEnabled;

    @OneToMany
    private Set<Privilege> privileges;

}
