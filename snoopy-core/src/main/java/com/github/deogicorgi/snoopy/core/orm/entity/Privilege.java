package com.github.deogicorgi.snoopy.core.orm.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;
}
