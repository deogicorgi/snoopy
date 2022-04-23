package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.orm.model.Privilege;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "privilege")
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrivilegeEntity extends Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
